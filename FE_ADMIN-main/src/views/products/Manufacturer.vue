<template>
  <div class="mb-3">
    <label for="formGroupExampleInput" class="form-label">Name</label>	
    <input	
      type="text"	
      class="form-control"	
      id="formGroupExampleInput"	
      v-model="form.name"	
    />	
  </div>	
  <div class="mb-3">	
    <label for="formGroupExampleInput2" class="form-label">Date</label>	
    <input	
      type="date"	
      class="form-control"	
      id="formGroupExampleInput2"	
      v-model="form.createdDate"	
    />	
  </div>	
  <div class="mb-3">	
    <label for="formGroupExampleInput" class="form-label">CreateBy</label>	
    <input	
      type="text"	
      class="form-control"	
      id="formGroupExampleInput"	
      v-model="form.createBy"	
    />	
  </div>	
  <div class="mb-3">	
    <label for="formGroupExampleInput2" class="form-label">UserName</label>	
    <input	
      type="text"	
      class="form-control"	
      id="formGroupExampleInput2"	
      v-model="form.username"	
    />	
  </div>	
  <button @click="insert()" class="btn btn-primary">Them</button>	
  <button @click="update()" class="btn btn-primary">Sua</button>	
  <table class="table">	
    <thead>	
      <tr>	
        <th scope="col">index</th>	
        <th scope="col">name</th>	
        <th scope="col">createdDate</th>	
        <th scope="col">createBy</th>	
        <th scope="col">username</th>	
      </tr>	
    </thead>	
    <tbody>	
      <tr v-for="(item, index) in response" :key="index">	
        <th scope="row">{{ index }}</th>	
        <td>{{ item.name }}</td>	
        <td>{{ item.createdDate }}</td>	
        <td>{{ item.createBy }}</td>	
        <td>{{ item.username }}</td>	
        <td><button @click="edit(item)">edit</button></td>	
      </tr>	
    </tbody>	
  </table>
</template>

<script>
import Axios from '../../commons/Axios.js'	
export default {	
  name: 'Manufacturer', 
  data() {	
    return {	
      response: [],	
      form: {	
        name: '',	
        isArray: false,	
        CreateBy: '',	
        username: '',	
      },	
    }	
  },	
  methods: {	
    showAll() {	
      Axios.get('manufacturer', this.form).then((response) => {	
        this.response = response.data	
        console.log(response)	
      })	
    },	
    insert() {	
      Axios.post('manufacturer', this.form).then((response) => {	
        console.log(response.data)	
        this.showAll()	
      })	
    },	
    update(item) {	
      Axios.put('manufacturer', this.form).then((response) => {	
        this.form = response.data	
        this.showAll();	
      })	
    },	
    edit(item){	
      this.form = {...item}	
    }	
  },	
  created: function () {	
    this.showAll()	
  },
  }
</script>
