export default [
  {
    component: 'CNavItem',
    name: 'Dashboard',
    to: '/dashboard',
    icon: 'cil-speedometer',
    badge: {
      color: 'primary',
      text: 'NEW',
    },
  },
  {
    component: 'CNavTitle',
    name: 'Theme',
  },
  {
    component: 'CNavItem',
    name: 'Colors',
    to: '/theme/colors',
    icon: 'cil-drop',
  },
  {
    component: 'CNavItem',
    name: 'Typography',
    to: '/theme/typography',
    icon: 'cil-pencil',
  },
  {
    component: 'CNavTitle',
    name: 'Components',
  }



  ,
  {
    component:'CNavGroup',
    name:"Sale-off",
    to:"/sale-off",
    icon:'cil-puzzle',
    items:[
      {
        component: 'CNavItem',
        name: 'Discount',
        to: '/sale-off/discount',
      },
      {
        component: 'CNavItem',
        name: 'Voucher',
        to: '/sale-off/voucher',
      },
      {
        component: 'CNavItem',
        name: 'Discount bill',
        to: '/sale-off/discount-bill',
          
      },
    ]
  },



  
  {
    component: 'CNavGroup',
    name: 'Products',
    to: '/products',
    icon: 'cil-puzzle',
    items: [
      {
        component: 'CNavItem',
        name: 'Categories',
        to: '/products/categories',
      },
      {
        component: 'CNavItem',
        name: 'Manufacturer',
        to: '/products/Manufacturer',
      },
      
      {
        component: 'CNavItem',
        name: 'Carousels',
        to: '/products/carousels',
      },
      {
        component: 'CNavItem',
        name: 'Image',
        to: '/products/image',
      },
      {
        component: 'CNavItem',
        name: 'List Groups',
        to: '/products/list-groups',
      },
      {
        component: 'CNavItem',
        name: 'Product ',
        to: '/products/product',
      },
      {
        component: 'CNavItem',
        name: 'HistoryPrice',
        to: '/products/historyPrice',
      },
      {
        component: 'CNavItem',
        name: 'Placeholders',
        to: '/products/placeholders',
      },
      {
        component: 'CNavItem',
        name: 'Popovers',
        to: '/products/popovers',
      },
      {
        component: 'CNavItem',
        name: 'Progress',
        to: '/products/progress',
      },
      {
        component: 'CNavItem',
        name: 'Spinners',
        to: '/products/spinners',
      },
      {
        component: 'CNavItem',
        name: 'Tables',
        to: '/products/tables',
      },
      {
        component: 'CNavItem',
        name: 'Tooltips',
        to: '/products/tooltips',
      },
    ],
  },
  {
    component: 'CNavGroup',
    name: 'Request',
    to : '/request',
    icon:'cil-bell',
    items:[
      {
        component : 'CNavItem',
        name: 'Return',
        to: '/request/return',
      },
      {
        component : 'CNavItem',
        name: 'Exchange',
        to: '/request/exchange',
      }
    ]
  },
  {
    component: 'CNavGroup',
    name: 'Buttons',
    to: '/buttons',
    icon: 'cil-cursor',
    items: [
      {
        component: 'CNavItem',
        name: 'Buttons',
        to: '/buttons/standard-buttons',
      },
      {
        component: 'CNavItem',
        name: 'Button Groups',
        to: '/buttons/button-groups',
      },
      {
        component: 'CNavItem',
        name: 'Dropdowns',
        to: '/buttons/dropdowns',
      },
    ],
  },
  {
    component: 'CNavGroup',
    name: 'Forms',
    to: '/forms',
    icon: 'cil-notes',
    items: [
      {
        component: 'CNavItem',
        name: 'Form Control',
        to: '/forms/form-control',
      },
      {
        component: 'CNavItem',
        name: 'Select',
        to: '/forms/select',
      },
      {
        component: 'CNavItem',
        name: 'Checks & Radios',
        to: '/forms/checks-radios',
      },
      {
        component: 'CNavItem',
        name: 'Range',
        to: '/forms/range',
      },
      {
        component: 'CNavItem',
        name: 'Input Group',
        to: '/forms/input-group',
      },
      {
        component: 'CNavItem',
        name: 'Floating Labels',
        to: '/forms/floating-labels',
      },
      {
        component: 'CNavItem',
        name: 'Layout',
        to: '/forms/layout',
      },
      {
        component: 'CNavItem',
        name: 'Validation',
        to: '/forms/validation',
      },
    ],
  },
  {
    component: 'CNavItem',
    name: 'Charts',
    to: '/charts',
    icon: 'cil-chart-pie',
  },
  {
    component: 'CNavGroup',
    name: 'Icons',
    to: '/icons',
    icon: 'cil-star',
    items: [
      {
        component: 'CNavItem',
        name: 'CoreUI Icons',
        to: '/icons/coreui-icons',
        badge: {
          color: 'info',
          text: 'NEW',
        },
      },
      {
        component: 'CNavItem',
        name: 'Brands',
        to: '/icons/brands',
      },
      {
        component: 'CNavItem',
        name: 'Flags',
        to: '/icons/flags',
      },
    ],
  },
  {
    component: 'CNavGroup',
    name: 'Notifications',
    to: '/notifications',
    icon: 'cil-bell',
    items: [
      {
        component: 'CNavItem',
        name: 'Alerts',
        to: '/notifications/alerts',
      },
      {
        component: 'CNavItem',
        name: 'Badges',
        to: '/notifications/badges',
      },
      {
        component: 'CNavItem',
        name: 'Modals',
        to: '/notifications/modals',
      },
    ],
  },
  {
    component: 'CNavItem',
    name: 'Widgets',
    to: '/widgets',
    icon: 'cil-calculator',
    badge: {
      color: 'primary',
      text: 'NEW',
      shape: 'pill',
    },
  },
  {
    component: 'CNavTitle',
    name: 'Extras',
  },
  {
    component: 'CNavGroup',
    name: 'Pages',
    to: '/pages',
    icon: 'cil-star',
    items: [
      {
        component: 'CNavItem',
        name: 'Login',
        to: '/pages/login',
      },
      {
        component: 'CNavItem',
        name: 'Register',
        to: '/pages/register',
      },
      {
        component: 'CNavItem',
        name: 'Error 404',
        to: '/pages/404',
      },
      {
        component: 'CNavItem',
        name: 'Error 500',
        to: '/pages/500',
      },
    ],
  },

  // {
  //   component: 'CNavItem',
  //   name: 'Download CoreUI',
  //   href: 'http://coreui.io/vue/',
  //   icon: { name: 'cil-cloud-download', class: 'text-white' },
  //   _class: 'bg-success text-white',
  //   target: '_blank'
  // },
  // {
  //   component: 'CNavItem',
  //   name: 'Try CoreUI PRO',
  //   href: 'http://coreui.io/pro/vue/',
  //   icon: { name: 'cil-layers', class: 'text-white' },
  //   _class: 'bg-danger text-white',
  //   target: '_blank'
  // }
]
