<template lang="html">

  <section class="order-view">
    <h1>order-view Component</h1>
  </section>

</template>

<script lang="js">

  export default  {
    name: 'order-view',
    props: [],
    mounted () {
      if(this.$session.has('user')){
        this.orders=this.$session.get('user').orders;
      }
    },
    data () {
      return {
        orders:null
      }
    },
    methods: {

    },
    computed: {

    }
}


</script>

<style scoped>
.order-view {
}
</style>
