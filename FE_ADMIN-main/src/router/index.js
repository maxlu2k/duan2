import { h, resolveComponent } from 'vue'
import { createRouter, createWebHashHistory } from 'vue-router'
import DefaultLayout from '@/layouts/DefaultLayout'
const routes = [
  {
    path: '/',
    name: 'Home',
    component: DefaultLayout,
    redirect: '/dashboard',
    children: [
      {
        path: '/dashboard',
        name: 'Dashboard',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () =>
          import(/* webpackChunkName: "dashboard" */ '@/views/Dashboard.vue'),
      },
      {
        path: '/theme',
        name: 'Theme',
        redirect: '/theme/typography',
      },
      {
        path: '/theme/colors',
        name: 'Colors',
        component: () => import('@/views/theme/Colors.vue'),
      },
      {
        path: '/theme/typography',
        name: 'Typography',
        component: () => import('@/views/theme/Typography.vue'),
      },





      {
        path: '/sale-off',
        name: 'Sale',
        redirect: '/sale-off/discount',
        component: {
          render() {
            return h(resolveComponent('router-view'))
          },
        },
        children:[
          {
            path: '/sale-off/discount',
            name: 'Discount',
            component: () => import('@/views/discount/Discount.vue'),
          },
          {
            path: '/sale-off/voucher',
            name: 'Voucher',
            component: () => import('@/views/discount/Voucher.vue'),
          },
          {
            path: '/sale-off/discount-bill',
            name: 'Discount bill',
            component: () => import('@/views/discount/DiscountWithBill.vue'),
          },
          {
            path: '/sale-off/voucher/:id',
            name: 'Voucher Product',
            component: () => import('@/views/discount/VoucherProduct.vue'),
          },
        ]
      }




      
      ,
      {
        path: '/products',
        name: 'Products',
        component: {
          render() {
            return h(resolveComponent('router-view'))
          },
        },
        redirect: '/products/manufacturer',
        children: [
          {
            path: '/products/categories',
            name: 'Categories',
            component: () => import('@/views/products/Categories.vue'),
          },
          {
            path: '/products/manufacturer',
            name: 'Manufacturer',
            component: () => import('@/views/products/Manufacturer.vue'),
          },
          {
            path: '/products/images',
            name: 'Images',
            component: () => import('@/views/products/Images.vue'),
          },
          {
            path: '/products/carousels',
            name: 'Carousels',
            component: () => import('@/views/products/Carousels.vue'),
          },
          {
            path: '/products/image',
            name: 'Image',
            component: () => import('@/views/products/Image.vue'),
          },
          {
            path: '/products/list-groups',
            name: 'List Groups',
            component: () => import('@/views/products/ListGroups.vue'),
          },
          {
            path: '/products/product',
            name: 'Product',
            component: () => import('@/views/products/Product.vue'),
          },
          {
            path: '/products/historyPrice',
            name: 'HistoryPrice',
            component: () => import('@/views/products/HistoryPrice.vue'),
          },
          {
            path: '/products/placeholders',
            name: 'Placeholders',
            component: () => import('@/views/products/Placeholders.vue'),
          },
          {
            path: '/products/popovers',
            name: 'Popovers',
            component: () => import('@/views/products/Popovers.vue'),
          },
          {
            path: '/products/progress',
            name: 'Progress',
            component: () => import('@/views/products/Progress.vue'),
          },
          {
            path: '/products/spinners',
            name: 'Spinners',
            component: () => import('@/views/products/Spinners.vue'),
          },
          {
            path: '/products/tables',
            name: 'Tables',
            component: () => import('@/views/products/Tables.vue'),
          },
          {
            path: '/products/tooltips',
            name: 'Tooltips',
            component: () => import('@/views/products/Tooltips.vue'),
          },
        ],
      },
      {
        path: '/request',
        name: 'Request',
        component:{
          render(){
            return h(resolveComponent('router-view'))
          }
        },
        children:[
          {
            path:'/request/return',
            name: 'Return',
            component: () => import("@/views/request/ReturnFigure.vue")
          },
          {
            path:'/request/exchange',
            name: 'Exchange',
            component: () => import("@/views/request/ExchangeFigure.vue")
          }
        ]
      },
      {
        path: '/buttons',
        name: 'Buttons',
        component: {
          render() {
            return h(resolveComponent('router-view'))
          },
        },
        redirect: '/buttons/standard-buttons',
        children: [
          {
            path: '/buttons/standard-buttons',
            name: 'Buttons',
            component: () => import('@/views/buttons/Buttons.vue'),
          },
          {
            path: '/buttons/dropdowns',
            name: 'Dropdowns',
            component: () => import('@/views/buttons/Dropdowns.vue'),
          },
          {
            path: '/buttons/button-groups',
            name: 'Button Groups',
            component: () => import('@/views/buttons/ButtonGroups.vue'),
          },
        ],
      },
      {
        path: '/forms',
        name: 'Forms',
        component: {
          render() {
            return h(resolveComponent('router-view'))
          },
        },
        redirect: '/forms/form-control',
        children: [
          {
            path: '/forms/form-control',
            name: 'Form Control',
            component: () => import('@/views/forms/FormControl.vue'),
          },
          {
            path: '/forms/select',
            name: 'Select',
            component: () => import('@/views/forms/Select.vue'),
          },
          {
            path: '/forms/checks-radios',
            name: 'Checks & Radios',
            component: () => import('@/views/forms/ChecksRadios.vue'),
          },
          {
            path: '/forms/range',
            name: 'Range',
            component: () => import('@/views/forms/Range.vue'),
          },
          {
            path: '/forms/input-group',
            name: 'Input Group',
            component: () => import('@/views/forms/InputGroup.vue'),
          },
          {
            path: '/forms/floating-labels',
            name: 'Floating Labels',
            component: () => import('@/views/forms/FloatingLabels.vue'),
          },
          {
            path: '/forms/layout',
            name: 'Layout',
            component: () => import('@/views/forms/Layout.vue'),
          },
          {
            path: '/forms/validation',
            name: 'Validation',
            component: () => import('@/views/forms/Validation.vue'),
          },
        ],
      },
      {
        path: '/charts',
        name: 'Charts',
        component: () => import('@/views/charts/Charts.vue'),
      },
      {
        path: '/icons',
        name: 'Icons',
        component: {
          render() {
            return h(resolveComponent('router-view'))
          },
        },
        redirect: '/icons/coreui-icons',
        children: [
          {
            path: '/icons/coreui-icons',
            name: 'CoreUI Icons',
            component: () => import('@/views/icons/CoreUIIcons.vue'),
          },
          {
            path: '/icons/brands',
            name: 'Brands',
            component: () => import('@/views/icons/Brands.vue'),
          },
          {
            path: '/icons/flags',
            name: 'Flags',
            component: () => import('@/views/icons/Flags.vue'),
          },
        ],
      },
      {
        path: '/notifications',
        name: 'Notifications',
        component: {
          render() {
            return h(resolveComponent('router-view'))
          },
        },
        redirect: '/notifications/alerts',
        children: [
          {
            path: '/notifications/alerts',
            name: 'Alerts',
            component: () => import('@/views/notifications/Alerts.vue'),
          },
          {
            path: '/notifications/badges',
            name: 'Badges',
            component: () => import('@/views/notifications/Badges.vue'),
          },
          {
            path: '/notifications/modals',
            name: 'Modals',
            component: () => import('@/views/notifications/Modals.vue'),
          },
        ],
      },
      {
        path: '/widgets',
        name: 'Widgets',
        component: () => import('@/views/widgets/Widgets.vue'),
      },
    ],
  },
  {
    path: '/pages',
    redirect: '/pages/404',
    name: 'Pages',
    component: {
      render() {
        return h(resolveComponent('router-view'))
      },
    },
    children: [
      {
        path: '404',
        name: 'Page404',
        component: () => import('@/views/pages/Page404'),
      },
      {
        path: '500',
        name: 'Page500',
        component: () => import('@/views/pages/Page500'),
      },
      {
        path: 'login',
        name: 'Login',
        component: () => import('@/views/pages/Login'),
      },
      {
        path: 'register',
        name: 'Register',
        component: () => import('@/views/pages/Register'),
      },
    ],
  },
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes,
  scrollBehavior() {
    // always scroll to top
    return { top: 0 }
  },
})

export default router
