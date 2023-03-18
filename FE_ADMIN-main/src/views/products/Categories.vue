<template>
  <div>
    <div>
      name
      <CFormInput v-model="form.name"
        type="text"
        placeholder="Default input"
        aria-label="default input example"
      /><br />
      update_by
      <CFormInput v-model="form.createBy"
        type="text"
        placeholder="Default input"
        aria-label="default input example"
      /><br />
      create_by<CFormInput v-model="form.updateBy"
        type="text"
        placeholder="Default input"
        aria-label="default input example"
      /><br />
      is_active
      <input type="radio" id="true" value="true" v-model="form.isActive" />
	<label for="false">True</label>
	<input type="radio" id="false" value="false" v-model="form.isActive" />
	<label for="false">False</label>
    </div>
  </div>
  <CTable>
    <CTableHead>
      <CTableRow>
        <CTableHeaderCell scope="col">#</CTableHeaderCell>
        <CTableHeaderCell scope="col">name</CTableHeaderCell>
        <CTableHeaderCell scope="col">created at</CTableHeaderCell>
      </CTableRow>
    </CTableHead>
    <CTableBody>
      <CTableRow v-for="(item, index) in response" :key="index">
        <CTableHeaderCell scope="row">{{ index }}</CTableHeaderCell>
        <CTableDataCell>{{ item.name }}</CTableDataCell>
        <CTableDataCell>{{ item.createDate }}</CTableDataCell>
        <CTableDataCell>{{ item.updateBy }}</CTableDataCell>
        <CTableDataCell>{{ item.createBy }}</CTableDataCell>
        <CTableDataCell>{{ item.isActive }}</CTableDataCell>
        <CTableDataCell><button @click="edit(item)">sua</button></CTableDataCell>
      </CTableRow>
    </CTableBody>
  </CTable>
  <button @click="insert()">them</button>
  <button @click="update(item)">cap nhap</button>
</template>

<script>
import Axios from '../../commons/Axios.js'
export default {
  data() {
    return {
      response: [],
      form: {
        name: '',
        isActive: false,
        createBy: '',
        updateBy: '',
      },
    }
  },

  methods: {
    showAll() {
      Axios.get('categories').then((response) => {
        this.response = response.data
        console.log(response)
      })
    },
    insert() {
      Axios.post('categories', this.form).then((response) => {
        console.log(response);
        this.showAll();
      })
    },
    update(item){
      Axios.put('categories', this.form).then((response) => {

        this.form = response.data 
        this.showAll();
      })
    },
    edit(item) {
      this.form = {...item};
    },
  },
  created: function () {
    this.showAll()
  },

  name: 'Categories',
}
</script>
