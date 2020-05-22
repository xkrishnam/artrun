<template lang="html">
<section class="section bg-gray">
	<!-- Container Start -->
	<div class="container">
		<div class="row">
			<!-- Left sidebar -->
			<div class="col-md-8">
				<div class="product-details">
					<h1 class="product-title">{{painting.title+' by '+painting.artist}}</h1>
					<div class="product-meta">
						<ul class="list-inline">
							<li class="list-inline-item"><i class="fa fa-user-o"></i> By <a href="">{{painting.artist}}</a></li>
							<li class="list-inline-item"><i class="fa fa-folder-open-o"></i> Category<a href="">Painting</a></li>
						</ul>
					</div>

					<!-- product slider -->
					<div class="product-slider">
							<img class="img-fluid w-100" 
              :src="require('../assets/media/'+painting.id+'.jpg')" 
              alt="product-img">
						
					</div>
					<!-- product slider -->

				</div>
			</div>
			<div class="col-md-4">
				<div class="sidebar">
					<div class="widget price text-center">
						<h4>Price</h4>
						<p>{{painting.price}}INR</p>
					</div>
					<!-- User Profile widget -->
					<div class="widget user text-center">
						<ul class="list-inline mt-20">
							<li class="list-inline-item"><a href="" 
              class="btn btn-offer d-inline-block btn-primary ml-n1 my-1 px-lg-4 px-md-3"
							v-on:click="addToCart">
              Add to cart</a></li>
						</ul>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- Container End -->
</section>

</template>

<script lang="js">
  const axios = require('axios');
  export default  {
    name: 'single-item',
    props: [],
    mounted () {
      axios
		.get('http://localhost:33445/art/'+this.$route.params.id)
		.then(response => (this.painting = response.data))
    },
    data () {
      return {
        painting : null,
				info: null,
      loading: true,
      errored: false
      }
    },
    methods: {
      addToCart :function(event) {
				event.preventDefault();
				var cid=0;
        if(!this.$session.exists()){
          this.$session.start();
        }else if(this.$session.has('user')){
					cid=this.$session.get('user').id;
				}
        axios
          .get('http://localhost:33445/addtocart/'+this.painting.id+'/'+cid)
          .then(response => {
						this.$session.set('user',response.data);
						if(this.$session.has('user')){
						this.$store.commit('updateCartCount',this.$session.get('user'));
						this.$router.push('/')
				}
      })
			.catch(error => {
        console.log(error)
        this.errored = true
      })
      .finally(() => {
				this.loading = false;
				})
    }
  }
}
</script>

<style scoped>
  .single-item {

  }
</style>
