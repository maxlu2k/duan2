<script setup>
import { CButton, CCard, CCardBody, CFormLabel, CFormTextarea, CRow, CFormSelect } from '@coreui/vue';
import { cilTrash, cilInfo, cilPenNib } from '@coreui/icons'
import { isNull, isValid, smaller, larger, SmallOrEqual, largerOrEqual, TodayDate, ToNumber, isBlank } from './util'
import Axios from '@/commons/Axios';
import { ref } from 'vue';

const lgDemo = ref(false);
let vouchers = ref([]);
let actionString = ref("New discount");
let voucher = ref({
    id: null,
    discountName: "TEO",
    minPrice: "",
    maxPrice: "",
    description: "",
    discountStart: null,
    discountEnd: null,
    discountType: null,
    discountAmount: null,
    status: false,
});
let voucherValidate = ref({
    name: null,
    minPrice: null,
    maxPrice: null,
    description: null,
    discountStart: null,
    discountEnd: null,
    discountType: null,
    discountAmount: null,
    status: null,
});

const validation = () => {
    let tmp = true;
    voucherValidate.value = {
        name: null,
        minPrice: null,
        maxPrice: null,
        description: null,
        discountStart: null,
        discountEnd: null,
        discountType: null,
        discountAmount: null,
        status: null,
    }
    // name
    if (isNull(voucher.value.discountName)) {
        tmp = false;
        voucherValidate.value.name = "Please fill name";
    }
    else if (!isValid(voucher.value.discountName.trim().length, 1, 120)) {
        tmp = false;
        voucherValidate.value.name = "Name from 1 to 120";
    }
    // type discount
    if (isNull(voucher.value.discountType)) {
        tmp = false;
        voucherValidate.value.discountType = "Please select type of voucher";
    }
    // discount amount
    if (isNull(voucher.value.discountAmount)) {
        tmp = false;
        voucherValidate.value.discountAmount = "Please fill discount amount";
    }
    else if (isNaN(voucher.value.discountAmount)) {
        tmp = false;
        voucherValidate.value.discountAmount = "Discount amount is number";
    }
    // start - end
    if (isNull(voucher.value.discountStart)) {
        tmp = false;
        voucherValidate.value.discountStart = "Please type start time";
    }
    if (isNull(voucher.value.discountEnd)) {
        tmp = false;
        voucherValidate.value.discountEnd = "Please type end time";
    }
    // min price
    if (isNull(voucher.value.minPrice)) {
        console.log("log");
        tmp = false;
    }
    else if (isNaN(voucher.value.minPrice)) {
        tmp = false;
        console.log("log");
        voucherValidate.value.minPrice = "Min price is number";
    }
    else if (smaller(new Number(voucher.value.minPrice), 0)) {
        tmp = false;

        console.log("log");
        voucherValidate.value.minPrice = "Min price larger or equal 0";
    }
    else if (isBlank(voucher.value.minPrice)) {
        tmp = false;
        voucherValidate.value.minPrice = "Min price larger or equal 0";
    }
    // max
    // if (isNull(voucher.value.maxPrice)) {

    //     if (voucher.value.maxPrice.trim().length > 0) {

    //         if (isNaN(voucher.value.maxPrice)) {
    //             tmp = false;
    //             voucherValidate.value.maxPrice = "Min price is number";
    //         }
    //         else if (smaller(new Number(voucher.minPrmaxPriceice), 0)) {
    //             tmp = false;
    //             voucherValidate.value.maxPrice = "Min price larger or equal 0";
    //         }
    //     }
    // }
    if (isNull(voucher.value.maxPrice)) {
        tmp = false;
    }
    else if (isNaN(voucher.value.maxPrice)) {
        tmp = false;
        voucherValidate.value.minPrice = "Max price is number";
    }
    else if (smaller(new Number(voucher.value.maxPrice), 0)) {
        tmp = false;
        voucherValidate.value.maxPrice = "Max price larger or equal 0";
    }
    else if (isBlank(voucher.value.maxPrice)) {
        tmp = false;
        voucherValidate.value.maxPrice = "Max price larger or equal 0";
    }
    if (voucher.value.discountType == 0) {
        // if (Number(voucher.value.discountAmount) > Number(voucher.value.maxPrice)) {
        //     tmp = false;
        //     voucherValidate.value.maxPrice = "Max price larger discount amount";
        // }
        if(Number(voucher.value.discountAmount) >100 || Number(voucher.value.discountAmount) <0 ){
            tmp = false;
            voucherValidate.value.discountAmount = "Discount amount from 0 to 100";
        }
    }

    if (isNull(voucher.value.status)) {
        tmp = false;
        voucherValidate.value.status = "Please select status of voucher";
    }
    return tmp;
}
function voucherConfirm() {
    if (!validation()) {
        console.log("logger");
        return;
    }
    lgDemo.value = false;
    if (voucher.value.id == null) {
        voucher.value.discountType = voucher.value.discountType.trim().length > 0 ? Number(voucher.value.discountType) : null;
        voucher.value.minPrice = voucher.value.minPrice.trim().length > 0 ? Number(voucher.value.minPrice) : null;
        voucher.value.maxPrice = voucher.value.maxPrice.trim().length > 0 ? Number(voucher.value.maxPrice) : null;

        console.log(voucher.value);
        if (voucher.value.discountType == 1) {
            voucher.value.maxPrice = null;
        }
        Axios.post("/discount-bill/new", voucher.value).then(function (resp) {
            console.log(resp.data);
            console.log(voucher.value);
            if (resp.data.infor_response.code == 200) {
                alert("Thêm voucher thành công ");
                vouchers.value.push(voucher.value);
            }
        }).catch((error) => {
            console.log(error);
            alert("Có lỗi xảy ra");
        })
    }
    else {
        Axios.put("/discount-bill/update", voucher.value).then(function (resp) {
            if (resp.data.infor_response.code == 200) {
                alert("Cập nhật voucher thành công ");
                // voucher.value.minPrice = Number(voucher.value.minPrice);
                // voucher.value.maxPrice = Number(voucher.value.maxPrice);
                // voucher.value.discountAmount = Number(voucher.value.discountAmount);
                vouchers.value.splice(vouchers.value.findIndex(item => item.id == voucher.value.id), 1, resp.data.data);
            }
            else{
                alert("Error : " + resp.data.infor_response.message);
            }
        }).catch((error) => {
            alert("Có lỗi xảy ra")
        })
    }
}
Axios.get("/discount-bill/get-all").then(function (resp) {
    console.log(resp.data.data.data);
    vouchers.value = resp.data.data.data

        .map((item) => {
            item.discountEnd = TodayDate(new Date(item.discountEnd));
            item.discountStart = TodayDate(new Date(item.discountStart));
            return item;
        });

}).catch(function (rejected) {
    alert("Có lỗi xảy ra" + rejected);
});
function edit(index) {
    actionString.value = 'Update discount';
    voucher.value = vouchers.value.find((item) => item.id == index);
    lgDemo.value = true;
}
function newVC() {
    voucherValidate.value = {
        name: null,
        minPrice: null,
        maxPrice: null,
        description: null,
        discountStart: null,
        discountEnd: null,
        discountType: null,
        discountAmount: null,
        status: null,
    }

    voucher.value = {
        id: null,
        discountName: "",
        minPrice: "",
        maxPrice: "",
        description: "",
        discountStart: TodayDate(new Date()),
        discountEnd: null,
        discountType: null,
        discountAmount: 0,
        status: false,
    };
    actionString.value = 'New discount';
    lgDemo.value = true;
}

function del(index) {
    if (confirm("Are you sure delete voucher with id : " + index)) {
        Axios.delete("/discount-bill/delete/" + index).then(resp => {
            rs = resp.data;
            if (resp.data.infor_response.code == 200) {
                alert(`Voucher ${index} has been deleted`);
            }

        }).catch(err => {
            alert(`Có lỗi xảy ra`);
        })
        vouchers.value.splice(vouchers.value.findIndex((item) => item.id == index), 1);
    }
}
</script>
<template>
    <CRow>
        <CCol>
            <CCard>

                <CCardHeader class="row m-0">
                    <div class="col col-md-10">
                        <div class="row d-flex justify-content-end">
                            <div class="col col-md-3">
                                <CFormInput placeholder="Name" />
                            </div>
                            <div class="col col-md-2">
                                <CFormFloating class="mb-3">
                                    <CFormInput placeholder="Start" type="date" />
                                    <CFormLabel for="discountName">From <span class="customValidateInput">*</span>
                                    </CFormLabel>
                                </CFormFloating>
                            </div>
                            <div class="col col-md-2">
                                <CFormFloating class="mb-3">
                                    <CFormInput placeholder="Start" type="date" />
                                    <CFormLabel for="discountName">End <span class="customValidateInput">*</span>
                                    </CFormLabel>
                                </CFormFloating>
                            </div>
                            <div class="col col-md-2">
                                <CFormSelect>
                                    <option value="3">All</option>
                                    <option value="1">Active</option>
                                    <option value="2">Non-Active</option>
                                </CFormSelect>
                            </div>
                            <div class="col col-md-2">
                                <CButton color="primary">Tìm kiếm</CButton>
                            </div>
                        </div>
                    </div>
                    <div class="col col-md-2">
                        <CButton color="primary" @click="newVC">
                            New discount</CButton>
                    </div>
                </CCardHeader>
                <CCardBody>
                    <CTable bordered hover>
                        <CTableHead class="text-center">
                            <CTableRow>
                                <CTableHeaderCell scope="col">#</CTableHeaderCell>
                                <CTableHeaderCell scope="col">Name</CTableHeaderCell>
                                <!-- <CTableHeaderCell scope="col">Quantity</CTableHeaderCell> -->
                                <CTableHeaderCell scope="col">Start</CTableHeaderCell>
                                <CTableHeaderCell scope="col">End</CTableHeaderCell>
                                <CTableHeaderCell scope="col">Min price</CTableHeaderCell>
                                <CTableHeaderCell scope="col">Max price</CTableHeaderCell>
                                <CTableHeaderCell scope="col">Amount</CTableHeaderCell>
                                <CTableHeaderCell scope="col">Status</CTableHeaderCell>
                                <CTableHeaderCell scope="col">Action</CTableHeaderCell>
                            </CTableRow>
                        </CTableHead>
                        <CTableBody>
                            <CTableRow v-for="(item, index) in vouchers" :key="index">
                                <CTableHeaderCell scope="row">{{ index }}</CTableHeaderCell>
                                <CTableDataCell>{{ item.discountName }}</CTableDataCell>
                                <CTableDataCell>{{ TodayDate(new Date(item.discountStart)) }}</CTableDataCell>
                                <CTableDataCell>{{ TodayDate(new Date(item.discountEnd)) }}</CTableDataCell>
                                <CTableDataCell>{{ item.minPrice }}</CTableDataCell>
                                <CTableDataCell>{{ item.maxPrice }}</CTableDataCell>
                                <CTableDataCell>{{
                                    item.discountType == 1 ? item.discountAmount + " VND" : item.discountAmount
                                + " %"
                                }}</CTableDataCell>
                                <CTableDataCell>{{
                                    item.status && new Date(item.discountEnd) > new Date() ? "Active" :
                                    (!item.status ? "Non-active" : "Expired")
                                }}</CTableDataCell>
                                <CTableDataCell class="d-flex flex-row ">
                                    <!-- <CButton color="warning" @click="edit(item.id)">Edit
                                                                                    </CButton> -->
                                    <span class="outter" @click="edit(item.id)" title="update">
                                        <CIcon :icon="cilPenNib" class="action-custom" size="lg" />
                                    </span>
                                    <!-- <CButton color="warning" @click="del(item.id)">
                                                                                    del
                                                                                    </CButton> -->
                                    <router-link class-active="active" class="outter" :to="`/sale-off/voucher/${item.id}`"
                                        title="infor">
                                        <CIcon :icon="cilInfo" class="action-custom" size="lg" />
                                    </router-link>
                                    <span class="outter" @click="del(item.id)" title="delete" v-if="item.status">
                                        <CIcon :icon="cilTrash" class="action-custom" size="lg" />
                                    </span>
                                    <!-- <router-link  class-active="active" class="outter" :to="{ path: '/sale-off/voucher/:id', params: { id: Number(item.id) } }" exact title="infor"> 
                                                                        <CIcon :icon="cilInfo" class="action-custom" size="lg" />
                                                                    </router-link> -->
                                </CTableDataCell>

                            </CTableRow>
                        </CTableBody>
                    </CTable>
                    <CModal alignment="center" backdrop="static" size="xl" :visible="lgDemo"
                        @close="() => { lgDemo = false }">
                        <CModalHeader dismiss @close="() => { lgDemo = false }">
                            <CModalTitle>{{ actionString }}</CModalTitle>
                        </CModalHeader>
                        <CModalBody>
                            <CForm>
                                <CRow>
                                    <CCol :md="6">
                                        <div class="mb-3">
                                            <CFormFloating class="mb-3">
                                                <CFormInput id="discountName" placeholder="Name" v-model="voucher.discountName" />
                                                <CFormLabel for="discountName">Name <span
                                                        class="customValidateInput">*</span></CFormLabel>
                                            </CFormFloating>
                                            <label for="discountName" class="customValidateInput"
                                                v-if="voucherValidate.name !== null">{{ voucherValidate.name }}</label>
                                        </div>
                                    </CCol>
                                    <CCol :md="6">
                                        <div class="mb-3">
                                            <CFormFloating class="mb-3">
                                                <CFormInput id="discountName" placeholder="Name" v-model="voucher.name" />
                                                <CFormLabel for="discountName">Name <span
                                                        class="customValidateInput">*</span></CFormLabel>
                                            </CFormFloating>
                                            <label for="discountName" class="customValidateInput"
                                                v-if="voucherValidate.name !== null">{{ voucherValidate.name }}</label>
                                        </div>
                                    </CCol>
                                </CRow>
                                <CRow>
                                    <CCol :md="6">
                                        <div class="mb-3">
                                            <CFormFloating class="mb-3">
                                                <CFormSelect id="floatingSelectGrid" v-model="voucher.discountType">
                                                    <option v-if="voucher.discountType === null"></option>
                                                    <option value=0>%</option>
                                                    <option value=1>VND</option>
                                                </CFormSelect>
                                                <CFormLabel for="floatingSelectGrid">Works with selects <span
                                                        class="customValidateInput">*</span>
                                                </CFormLabel>
                                            </CFormFloating>
                                            <label for="discountQuantity" class="customValidateInput"
                                                v-if="voucherValidate.discountType !== null">{{
                                                    voucherValidate.discountType
                                                }}</label>

                                        </div>
                                    </CCol>
                                    <CCol :md="6">
                                        <div class="mb-3">
                                            <CFormFloating class="mb-3">
                                                <CFormInput id="discountAmount" placeholder="Discount amount"
                                                    v-model.lazy="voucher.discountAmount" />
                                                <CFormLabel for="discountAmount">Discount amount <span
                                                        class="customValidateInput">*</span></CFormLabel>
                                            </CFormFloating>
                                            <label for="discountQuantity" class="customValidateInput"
                                                v-if="voucherValidate.discountAmount !== null">{{
                                                    voucherValidate.discountAmount
                                                }}</label>

                                        </div>
                                    </CCol>
                                </CRow>
                                <CRow>
                                    <CCol :md="6">
                                        <div class="mb-3">
                                            <CFormLabel for="start">Start <span class="customValidateInput">*</span>
                                            </CFormLabel>
                                            <CFormInput id="start" type="date" v-model="voucher.discountStart"
                                                :value="(voucher.discountStart)" />
                                        </div>
                                        <label for="discountQuantity" class="customValidateInput"
                                            v-if="voucherValidate.discountStart !== null">{{
                                                voucherValidate.discountStart
                                            }}</label>

                                    </CCol>
                                    <CCol :md="6">
                                        <div class="mb-3">
                                            <CFormLabel for="end">End <span class="customValidateInput">*</span>
                                            </CFormLabel>
                                            <CFormInput id="end" type="date" v-model="voucher.discountEnd"
                                                :value="(voucher.discountEnd)" />
                                        </div>
                                        <label for="discountQuantity" class="customValidateInput"
                                            v-if="voucherValidate.discountEnd !== null">{{
                                                voucherValidate.discountEnd
                                            }}</label>

                                    </CCol>
                                </CRow>
                                <CRow class="mt-3">
                                    <CCol :md="6">
                                        <div class="mb-3">
                                            <CFormFloating class="mb-3">
                                                <CFormInput id="minPrice" placeholder="Min price"
                                                    v-model="voucher.minPrice" />
                                                <CFormLabel for="minPrice">Min price</CFormLabel>
                                            </CFormFloating>
                                            <label for="discountQuantity" class="customValidateInput"
                                                v-if="voucherValidate.minPrice !== null">{{
                                                    voucherValidate.minPrice
                                                }}</label>

                                        </div>
                                    </CCol>
                                    <CCol :md="6">
                                        <div class="mb-3">
                                            <CFormFloating class="mb-3">
                                                <CFormInput id="maxPrice" placeholder="Max price"
                                                    :disabled="voucher.discountType == 1" v-model="voucher.maxPrice" />
                                                <CFormLabel for="maxPrice">Max price</CFormLabel>
                                            </CFormFloating>
                                            <label for="discountQuantity" class="customValidateInput"
                                                v-if="voucherValidate.maxPrice !== null">{{
                                                    voucherValidate.maxPrice
                                                }}</label>
                                        </div>
                                    </CCol>
                                </CRow>
                                <CRow>
                                    <div class="mb-3">
                                        <CFormFloating class="mb-3">
                                            <CFormTextarea id="description" placeholder="Description"
                                                v-model="voucher.description" />
                                            <CFormLabel for="description">Description</CFormLabel>
                                        </CFormFloating>
                                    </div>
                                </CRow>
                                <CRow>
                                    <CCol>
                                        <div class="mb-3">
                                            <CFormLabel for="voucherNActive">Status <span class="customValidateInput">* {{
                                                voucher.status }}</span>
                                            </CFormLabel>
                                            <!-- <CFormCheck type="radio" name="voucherstatus" v-model="voucher.status"
                                                                                            :value="voucher.status" value="true"  label="Active" />
                                                                                        <CFormCheck type="radio" name="voucherstatus" v-model="voucher.status"
                                                                                            :value="voucher.status" value="false" label="Non-active" /> -->
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="voucherstatus"
                                                    v-model="voucher.status" value="true" id="flexRadioDefault1">
                                                <label class="form-check-label" for="flexRadioDefault1">
                                                    Active
                                                </label>
                                            </div>
                                            <div class="form-check">
                                                <input class="form-check-input" type="radio" name="voucherstatus"
                                                    v-model="voucher.status" value="false" id="flexRadioDefault2">
                                                <label class="form-check-label" for="flexRadioDefault2">
                                                    Non-active
                                                </label>
                                            </div>
                                            <label for="discountQuantity" class="customValidateInput"
                                                v-if="voucherValidate.status !== null">{{
                                                    voucherValidate.status
                                                }}</label>
                                        </div>
                                    </CCol>
                                </CRow>
                            </CForm>
                        </CModalBody>
                        <CModalFooter>
                            <CButton color="secondary" @click="() => { lgDemo = false }">
                                Close
                            </CButton>
                            <CButton color="primary" @click="voucherConfirm">Confirm</CButton>
                        </CModalFooter>
                    </CModal>
                </CCardBody>
            </CCard>
        </CCol>
    </CRow>
</template>
<style>
#floatingSelectGrid {
    padding-top: 20px;
}

.action-custom {
    color: slateblue;
    margin: 10px;
}

.outter {
    height: 40px;
}

.outter:hover {
    cursor: pointer;
    background-color: rgba(15, 51, 195, 0.1);
    opacity: 0.9;
    border-radius: 50%;
}

.outter:hover .action-custom {
    color: red;
}

.customValidateInput {
    color: red;
    opacity: 0.65;
}
</style>