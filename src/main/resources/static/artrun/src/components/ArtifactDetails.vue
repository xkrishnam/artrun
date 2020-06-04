<template lang="html">
          <!-- product card -->
          <div class="product-item bg-light">
            <div class="card">
              <div class="thumb-content">
                <router-link :to="'/art/'+id">
                  <img
                    class="card-img-top"
                    :src="getContentImageLink(id)"
                    alt="Card image cap"
                  />
                </router-link>
              </div>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="single.html">{{title+' by '+artist}}</a>
                  <p>{{price}}INR</p>
                </h4>
              </div>
            </div>
          </div>
</template>

<script lang="js">

  export default  {
    name: 'artifact-details',
    props: {id:String,title:String,artist:String,price:Number,category:String,},
    mounted () {

    },
    data () {
      return {

      }
    },
    methods: {
      getContentImageLink(id) {
        return this.$g("img_base_url") + id + ".jpg";
      }
    },
    computed: {

    }
}


</script>

<style scoped>
.artifact-details {
}
</style>
