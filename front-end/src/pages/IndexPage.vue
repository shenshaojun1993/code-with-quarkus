<template>
  <q-page class="flex_1">
    <q-table
      title="Treats"
      :rows="rows"
      :columns="columns"
      row-key="name"
      :pagination="initialPagination"
    />
  </q-page>
</template>

<script>
import { defineComponent, reactive } from 'vue'

export default defineComponent({
  name: 'IndexPage',

})
</script>
