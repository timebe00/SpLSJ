<template>
  <button @click = "addCounter">{{ counter }}</button>
</template>

<script>
export default {
  name: 'abc',
  props: ['cka'],
  template: '<button @click="addCounter">{{ counter }}</button>',
  data: function () {
    return {
      counter: this.cka
    }
  },
  methods: {
    addCounter: function () {
      this.counter += 1
    }
  }
}
</script>
