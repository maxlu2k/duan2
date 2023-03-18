<template>
  <table>
    <thead>
      <tr class="thead">
        <th scope="col">id</th>
        <th scope="col">character</th>
        <th scope="col">available</th>
        <th scope="col">manufactur</th>
        <th scope="col">seriesID</th>
        <th scope="col">categoryId</th>
        <th scope="col">Detail</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(item, index) in response" :key="index">
        <td data-label="Name">{{ index }}</td>
        <td data-label="Title">{{ item.characterr }}</td>
        <td data-label="Website">{{ item.available }}</td>
        <td data-label="Website">{{ item.manufacturerID }}</td>
        <td data-label="Website">{{ item.seriesID }}</td>
        <td data-label="Website">{{ item.categoryId }}</td>
        <td data-label="Website">
          <CButton color="primary" @click="
            () => {
              visibleLiveDemo = true
            }
          ">Detail</CButton>
        </td>
      </tr>
    </tbody>
    <CButton color="primary" @click="
      () => {
        them = true
      }
    ">Them</CButton>
    <button>Sua</button>
  </table>
<!-- Modal detail -->
  <CModal :visible="visibleLiveDemo" @close="
    () => {
      visibleLiveDemo = false
    }
  ">
    <div class="modal-content" style="width: 380%; display: flex; align-items: center">
      <CModalHeader>
        <CModalTitle>Modal title</CModalTitle>
      </CModalHeader>
      <CModalBody>
        <table class="table">
          <thead>
            <tr>
              <th scope="col">id</th>
              <th scope="col">characterr</th>
              <th scope="col">available</th>
              <th scope="col">description</th>
              <th scope="col">rate</th>
              <th scope="col">ratio</th>
              <th scope="col">quantity</th>
              <th scope="col">material</th>
              <th scope="col">meri</th>
              <th scope="col">title</th>
              <th scope="col">createBy</th>
              <th scope="col">updateBy</th>
              <th scope="col">height</th>
              <th scope="col">weight</th>
              <th scope="col">recommendedAge</th>
              <th scope="col">accessoriesIncluded</th>
              <th scope="col">price</th>
              <th scope="col">gender</th>
              <th scope="col">manufacturerID</th>
              <th scope="col">seriesID</th>
              <th scope="col">categoryId</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(item, index) in response" :key="index">
              <th scope="row">1</th>
              <td>{{ index }}</td>
              <td>{{ item.characterr }}</td>
              <td>{{ item.available }}</td>
              <td>{{ item.description }}</td>
              <td>{{ item.rate }}</td>
              <td>{{ item.ratio }}</td>
              <td>{{ item.quantity }}</td>
              <td>{{ item.material }}</td>
              <td>{{ item.meri }}</td>
              <td>{{ item.title }}</td>
              <td>{{ item.createBy }}</td>
              <td>{{ item.updateBy }}</td>
              <td>{{ item.height }}</td>
              <td>{{ item.weight }}</td>
              <td>{{ item.recommendedAge }}</td>
              <td>{{ item.accessoriesIncluded }}</td>
              <td>{{ item.price }}</td>
              <td>{{ item.gender }}</td>
              <td>{{ item.manufacturerID }}</td>
              <td>{{ item.seriesID }}</td>
              <td>{{ item.categoryId }}</td>
            </tr>
          </tbody>
        </table>
      </CModalBody>
      <CModalFooter>
        <CButton color="secondary" @click="
          () => {
            visibleLiveDemo = false
          }
        ">
          Close
        </CButton>
        <CButton color="primary">Save changes</CButton>
      </CModalFooter>
    </div>
  </CModal>

  <!-- Modal Them -->
  <CModal :visible="them" @close="
    () => {
      them = false
    }
  ">
    <div class="modal-content" style="width: 380%; display: flex; align-items: center">
      <CModalHeader>
        <CModalTitle>Modal title</CModalTitle>
      </CModalHeader>
      <CModalBody>

      </CModalBody>
      <CModalFooter>
        <CButton color="secondary" @click="
          () => {
            them = false
          }
        ">
          Close
        </CButton>
        <CButton color="primary">Save changes</CButton>
      </CModalFooter>
    </div>
  </CModal>
</template>

<script>
import Axios from '@/commons/Axios'
export default {
  data() {
    return {
      visibleLiveDemo: false,
      them: false,
      response: [],
      form: {
        character: '',
        available: '',
        manufacturerID: '',
        seriesID: '',
        categoryId: '',
      },
    }
  },
  methods: {
    showAll() {
      Axios.get('products', this.form).then((response) => {
        this.response = response.data
        console.log(response)
      })
    },
  },
  created: function () {
    this.showAll()
  },
  name: 'Product',
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;600;700&display=swap');

* {
  font-family: 'Ubuntu', sans-serif;
}

body {
  height: 98vh;
  background-color: #4158d0;
  background-image: linear-gradient(43deg,
      #4158d0 0%,
      #c850c0 46%,
      #ffcc70 100%);
  font-family: 'Ubuntu', sans-serif;
  background-position: center center;
}

table {
  /*   border: 1px solid #ccc; */
  border-collapse: collapse;
  margin: 0 auto;
  padding: 0;
  width: 80%;
  table-layout: fixed;
}

table caption {
  font-family: 'Ubuntu', sans-serif;
  font-size: 55px;
  font-weight: 700;
  color: #00000090;
  padding: 15px;
}

table tr {
  background-color: #ffffff90;
  border: 1px solid #ddd;
  padding: 10px;
}

.thead {
  background-color: rgb(67 56 202);
  color: #fff;
}

table th,
table td {
  padding: 20px;
  text-align: center;
}

table th {
  font-size: 20px;
  letter-spacing: 0.1em;
  text-transform: capitalize;
}

@media screen and (max-width: 600px) {
  table {
    border: 0;
  }

  .thead {
    background-color: rgb(67 56 202);
    color: #fff;
  }

  table caption {
    font-size: 35px;
    font-weight: 700;
    color: #00000090;
  }

  table thead {
    border: none;
    clip: rect(0 0 0 0);
    height: 1px;
    margin: -1px;
    overflow: hidden;
    padding: 0;
    position: absolute;
    width: 1px;
  }

  table tr {
    border-bottom: 3px solid #ddd;
    display: block;
    margin-bottom: 0.625em;
  }

  table td {
    border-bottom: 1px solid #ddd;
    display: block;
    font-size: 0.8em;
    text-align: right;
  }

  table td::before {
    /*
    * aria-label has no advantage, it won't be read inside a table
    content: attr(aria-label);
    */
    content: attr(data-label);
    float: left;
    font-weight: bold;
    text-transform: uppercase;
  }

  table td:last-child {
    border-bottom: 0;
  }
}
</style>
