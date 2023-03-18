<template>
  <Crow>
    <Ccol :xs="12">
      <CCard class="mb-4">
        <CCardHeader>
          <strong>Return Figure</strong>
        </CCardHeader>
        <CCardBody>
          <CNav variant="tabs" role="tablist">
            <CNavItem>
              <CNavLink
                href="javascript:void(0);"
                :active="tabPaneActiveKey === 1"
                @click="
                  () => {
                    tabPaneActiveKey = 1
                  }
                "
              >
                Tất cả
              </CNavLink>
            </CNavItem>
            <CNavItem class="position-relative">
              <CNavLink
                href="javascript:void(0);"
                :active="tabPaneActiveKey === 2"
                @click="
                  () => {
                    tabPaneActiveKey = 2
                  }
                "
              >
                Yêu cầu mới
              </CNavLink>
              <CBadge color="danger" position="top-end" shape="rounded-pill">
                99+ <span class="visually-hidden">unread messages</span>
              </CBadge>
            </CNavItem>
            <CNavItem>
              <CNavLink
                href="javascript:void(0);"
                :active="tabPaneActiveKey === 3"
                @click="
                  () => {
                    tabPaneActiveKey = 3
                  }
                "
              >
                Cần phản hồi
              </CNavLink>
            </CNavItem>
            <CNavItem>
              <CNavLink
                href="javascript:void(0);"
                :active="tabPaneActiveKey === 4"
                @click="
                  () => {
                    tabPaneActiveKey = 4
                  }
                "
              >
                Đã phản hồi
              </CNavLink>
            </CNavItem>
            <CNavItem>
              <CNavLink
                href="javascript:void(0);"
                :active="tabPaneActiveKey === 5"
                @click="
                  () => {
                    tabPaneActiveKey = 5
                  }
                "
              >
                Hoàn thành
              </CNavLink>
            </CNavItem>
          </CNav>
          <CTabContent>
            <CTabPane
              role="tabpanel"
              aria-labelledby="home-tab"
              :visible="tabPaneActiveKey === 1"
            >
            </CTabPane>
            <CTabPane
              role="tabpanel"
              aria-labelledby="profile-tab"
              :visible="tabPaneActiveKey === 2"
            >
              <CTable>
                <thead>
                  <tr>
                    <th>#</th>
                    <th>Tên sản phẩm</th>
                    <th>Số lượng</th>
                    <th>Lý do hoàn trả</th>
                    <th>Trạng thái</th>
                    <th>Tổng tiền hoàn lại</th>
                    <th>Action</th>
                  </tr>
                </thead>
                <tbody style="text-align: left">
                  <tr v-for="(person, index) in people" :key="index">
                    <td>{{ person.id }}</td>
                    <td>{{ person.name }}</td>
                    <td>{{ person.quantity }}</td>
                    <td>{{ person.reason }}</td>
                    <td>{{ person.status }}</td>
                    <td>{{ person.total }}</td>
                    <td>
                      <CButton color="success" variant="outline"
                        >Phản hồi</CButton
                      >
                      <p class="m-1"></p>
                      <CButton color="danger" variant="outline"
                        >Chi tiết</CButton
                      >
                    </td>
                  </tr>
                </tbody>
                <tfoot>
                  <CPagination aria-label="Page navigation example">
                    <CPaginationItem aria-label="Previous" href="#"
                      ><span aria-hidden="true">&laquo;</span></CPaginationItem
                    >
                    <CPaginationItem href="#">1</CPaginationItem>
                    <CPaginationItem href="#">2</CPaginationItem>
                    <CPaginationItem href="#">3</CPaginationItem>
                    <CPaginationItem aria-label="Next" href="#"
                      ><span aria-hidden="true">&raquo;</span></CPaginationItem
                    >
                  </CPagination>
                </tfoot>
              </CTable>
            </CTabPane>
            <CTabPane
              role="tabpanel"
              aria-labelledby="contact-tab"
              :visible="tabPaneActiveKey === 3"
            >
              <CTable>
                <thead>
                  <tr>
                    <th>#</th>
                    <th>Tên sản phẩm</th>
                    <th>Số lượng</th>
                    <th>Lý do hoàn trả</th>
                    <th>Trạng thái</th>
                    <th>Tổng tiền hoàn lại</th>
                    <th>Action</th>
                  </tr>
                </thead>
                <tbody style="text-align: left">
                  <tr v-for="(person, index) in people" :key="index">
                    <td>{{ person.id }}</td>
                    <td>{{ person.name }}</td>
                    <td>{{ person.quantity }}</td>
                    <td>{{ person.reason }}</td>
                    <td>{{ person.status }}</td>
                    <td>{{ person.total }}</td>
                    <td>
                      <CButton color="success" variant="outline"
                        >Phản hồi</CButton
                      >
                      <p class="m-1"></p>
                      <CButton
                        color="danger"
                        variant="outline"
                        >Chi tiết</CButton
                      >
                    </td>
                  </tr>
                </tbody>
                <tfoot>
                  <CPagination aria-label="Page navigation example">
                    <CPaginationItem aria-label="Previous" href="#"
                      ><span aria-hidden="true">&laquo;</span></CPaginationItem
                    >
                    <CPaginationItem href="#">1</CPaginationItem>
                    <CPaginationItem href="#">2</CPaginationItem>
                    <CPaginationItem href="#">3</CPaginationItem>
                    <CPaginationItem aria-label="Next" href="#"
                      ><span aria-hidden="true">&raquo;</span></CPaginationItem
                    >
                  </CPagination>
                </tfoot>
              </CTable>
            </CTabPane>
            <CTabPane
              role="tabpanel"
              aria-labelledby="profile-tab"
              :visible="tabPaneActiveKey === 4"
            >
              <CTable>
                <thead>
                  <tr>
                    <th>#</th>
                    <th>Tên sản phẩm</th>
                    <th>Số lượng</th>
                    <th>Lý do hoàn trả</th>
                    <th>Tổng tiền hoàn lại</th>
                    <th>Trạng thái</th>
                    <th>Action</th>
                  </tr>
                </thead>
                <tbody style="text-align: left">
                  <tr v-for="(person, index) in people" :key="index">
                    <td>{{ person.id }}</td>
                    <td>{{ person.name }}</td>
                    <td>{{ person.quantity }}</td>
                    <td>{{ person.reason }}</td>
                    <td>{{ person.total }}</td>
                    <td>{{ person.status }}</td>
                    <td>
                      <CButton
                        color="danger"
                        variant="outline"
                        style="width: 94.64px"
                        >Chi tiết</CButton
                      >
                    </td>
                  </tr>
                </tbody>
                <tfoot>
                  <CPagination aria-label="Page navigation example">
                    <CPaginationItem aria-label="Previous" href="#"
                      ><span aria-hidden="true">&laquo;</span></CPaginationItem
                    >
                    <CPaginationItem href="#">1</CPaginationItem>
                    <CPaginationItem href="#">2</CPaginationItem>
                    <CPaginationItem href="#">3</CPaginationItem>
                    <CPaginationItem aria-label="Next" href="#"
                      ><span aria-hidden="true">&raquo;</span></CPaginationItem
                    >
                  </CPagination>
                </tfoot>
              </CTable>
            </CTabPane>
            <CTabPane
              role="tabpanel"
              aria-labelledby="profile-tab"
              :visible="tabPaneActiveKey === 5"
            >
              <CTable>
                <thead>
                  <tr>
                    <th>#</th>
                    <th>Tên sản phẩm</th>
                    <th>Số lượng</th>
                    <th>Lý do hoàn trả</th>
                    <th>Tổng tiền hoàn lại</th>
                    <th>Trạng thái</th>
                  </tr>
                </thead>
                <tbody style="text-align: left">
                  <tr v-for="(person, index) in people" :key="index">
                    <td>{{ person.id }}</td>
                    <td>{{ person.name }}</td>
                    <td>{{ person.quantity }}</td>
                    <td>{{ person.reason }}</td>
                    <td>{{ person.total }}</td>
                    <td>{{ person.status }}</td>
                  </tr>
                </tbody>
                <tfoot>
                  <CPagination aria-label="Page navigation example">
                    <CPaginationItem aria-label="Previous" href="#"
                      ><span aria-hidden="true">&laquo;</span></CPaginationItem
                    >
                    <CPaginationItem href="#">1</CPaginationItem>
                    <CPaginationItem href="#">2</CPaginationItem>
                    <CPaginationItem href="#">3</CPaginationItem>
                    <CPaginationItem aria-label="Next" href="#"
                      ><span aria-hidden="true">&raquo;</span></CPaginationItem
                    >
                  </CPagination>
                </tfoot>
              </CTable>
            </CTabPane>
          </CTabContent>
        </CCardBody>
      </CCard>
    </Ccol>
  </Crow>
</template>

<script setup>
import { ref } from 'vue'
let tabPaneActiveKey = ref(1)
// export default{
//   data() {
//     return {
//       response: [],
//       item: {
//         name: '',
//         lydo
//       }
//     }
//   }
// }
</script>
<script>
export default {
  data() {
    return {
      people: [
        {
          id: 1,
          name: 'Anime Luffy',
          quantity: 1,
          reason: 'Vỡ',
          status: true,
          total: '400.000',
        },
        {
          id: 2,
          name: 'Anime Sabo',
          quantity: 1,
          reason: 'Hỏng',
          status: true,
          total: '350.000 ',
        },
        {
          id: 3,
          name: 'Anime Ace',
          quantity: 1,
          reason: 'Thiếu',
          status: true,
          total: '350.000 ',
        },
      ],
    }
  },
}
</script>