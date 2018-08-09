// const server = "http://localhost:8080"
const server = "https://springboot-mybatis.herokuapp.com";

new Vue({
  el: '#app',
  data: {
    columns: ['Index', 'Last Name', 'First Name', 'Age', 'Job', 'Address', 'Actions '],
    persons: [],
    bin: [],
    input: {
      lname: "WADE",
      fname: "Johnson",
      age: 38,
      job: "Comedian",
      address: "Roma/Italia"
    },
    editInput: {
      lname: "",
      fname: "",
      age: 0,
      job: "",
      address: ""
    },
    errors: []
  },
  async created() {
    await this.fetchPersons();  
  },
  methods: {
    //function to add data to table
    add: async function () {
      let person = {
        lastName: this.input.lname,
        firstName: this.input.fname,
        age: this.input.age,
        job: this.input.job,
        address: this.input.address
      };

      try {
        const resAdd = await fetch(server + '/api/employees', {
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          }, method: "POST", body: JSON.stringify(person), mode: "no-cors"
        });

        if (resAdd.status === 200) {
          this.fetchPersons();

          for (var key in this.input) {
            this.input[key] = '';
          }
          this.persons.sort(ordonner);
          this.$refs.lname.focus();
        } else {
          alert('ada error');
        }
      } catch (e) {
        this.errors.push(e)
      }

    },
    //function to handle data edition
    edit: function (index) {
      this.editInput = this.persons[index];
      console.log(this.editInput);
      this.persons.splice(index, 1);
    },
    //function to send data to bin
    archive: function (index) {
      this.bin.push(this.persons[index]);
      this.persons.splice(index, 1);
      this.bin.sort(ordonner);
    },
    //function to restore data
    restore: function (index) {
      this.persons.push(this.bin[index]);
      this.bin.splice(index, 1);
      this.bin.sort(ordonner);
    },
    //function to update data
    update: async function() {
      // this.persons.push(this.editInput);
      let person = {
        id: this.editInput.id,
        lastName: this.editInput.lname,
        firstName: this.editInput.fname,
        age: this.editInput.age,
        job: this.editInput.job,
        address: this.editInput.address
      };

      try {
        const resEdit = await fetch(server + '/api/employees/' + person.id, {
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          }, method: "POST", body: JSON.stringify(person), mode: "no-cors"
        });

        if (resEdit.status === 200) {
          this.fetchPersons();

          for (var key in this.editInput) {
            this.editInput[key] = '';
          }
          this.persons.sort(ordonner);
        } else {
          alert('ada error');
        }
      } catch (e) {
        this.errors.push(e)
      }

    },
    //function to defintely delete data 
    deplete: async function (index) {
      // console.log(this.bin[index]);
      let person = this.bin[index];
      try {
        await fetch(server + '/api/employees/' + person.id, {
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          }, method: "DELETE", mode: "no-cors"
        });
      this.bin.splice(index, 1);
      } catch(e) {
        this.errors.push(e);
      }
    },
    fetchPersons: async function(){
      try {
        const response = await fetch(server + '/api/employees', {mode: "no-cors"});
        this.persons = await response.json();
        this.persons = this.persons.map(person => ({ ...person, lname: person.lastName, fname: person.firstName }));
      } catch (e) {
        this.errors.push(e)
      }
    }
  }
});

//function to sort table data alphabetically
var ordonner = function (a, b) {
  return (a.lname > b.lname);
};

$(function () {
  //initialize modal box with jquery
  $('.modal').modal();
});
