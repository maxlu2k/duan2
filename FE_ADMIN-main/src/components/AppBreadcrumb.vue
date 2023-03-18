<template>
  <CBreadcrumb class="d-md-down-none me-auto mb-0">
    <CBreadcrumbItem
      v-for="item in manufacturer"
      :key="item"
      :href="item.active ? '' : item.path"
      :active="item.active"
    >
      {{ item.name }}
    </CBreadcrumbItem>
  </CBreadcrumb>
</template>

<script>
import { onMounted, ref } from 'vue'
import router from '@/router'

export default {
  name: 'AppBreadcrumb',
  setup() {
    const manufacturer = ref()

    const getManufacturer = () => {
      return router.currentRoute.value.matched.map((route) => {
        return {
          active: route.path === router.currentRoute.value.fullPath,
          name: route.name,
          path: `${router.options.history.base}${route.path}`,
        }
      })
    }

    router.afterEach(() => {
      manufacturer.value = getManufacturer()
    })

    onMounted(() => {
      manufacturer.value = getManufacturer()
    })

    return {
      manufacturer,
    }
  },
}
</script>
