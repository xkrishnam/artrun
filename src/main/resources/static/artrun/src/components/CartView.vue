<template lang="html">

  <section class="dashboard section">
	<!-- Container Start -->
	<div class="container">
		<!-- Row Start -->
		<div class="row">
			<div class="col-md-12 offset-md-0 col-lg-12 offset-lg-0">
				<!-- Recently Favorited -->
				<div class="widget dashboard-container my-adslist">
					<h3 class="widget-header">My Ads</h3>
					<table class="table table-responsive product-dashboard-table">
						<thead>
							<tr>
								<th>Image</th>
								<th>Product Title</th>
								<th class="text-center">Price</th>
								<th class="text-center">Action</th>
							</tr>
						</thead>
						<tbody>
							<tr v-bind:key = "painting.id" v-for="painting in paintings">

								<td class="product-thumb">
									<img width="80px" height="auto" 
                  :src="getContentImageLink(painting.id)" 
                  alt="image description">
                </td>
								<td class="product-details">
									<h3 class="title">{{painting.title}}</h3>
								</td>
								<td class="product-category"><span class="categories">{{painting.price}}INR</span></td>
								<td class="action" data-title="Action">
									<div class="">
										<ul class="list-inline justify-content-center">
											<li class="list-inline-item">
                        <router-link :to="'/art/'+painting.id" 
                        data-toggle="tooltip" data-placement="top" title="Edit" class="edit">
													<i class="fa fa-eye"></i>
												</router-link>
											</li>
											<li class="list-inline-item">
												<a data-toggle="tooltip" data-placement="top" title="Delete" class="delete" v-on:click="removeFromCart(painting.id, $event)">
													<i class="fa fa-trash"></i>
												</a>
											</li>
										</ul>
									</div>
								</td>
							</tr>
						</tbody>
					</table>

				</div>
				<!-- pagination -->
        <div class="widget user text-center">
						<ul class="list-inline mt-20">
							<li class="list-inline-item"><a href=""
              class="btn btn-offer d-inline-block btn-primary ml-n1 my-1 px-lg-4 px-md-3"
							v-on:click="checkout">
              Checkout</a></li>
						</ul>
					</div>
			</div>
		</div>
		<!-- Row End -->
	</div>
	<!-- Container End -->
</section>

</template>

<script lang="js">
const axios = require('axios');
  export default  {
    name: 'cart-view',
    props: [],
    mounted () {
      if(this.$session.has('user')){
        this.paintings=this.$session.get('user').cart.paintings;
      }
    },
    data () {
      return {
        paintings:null
      }
    },
    methods: {
		getContentImageLink(id) {
      return this.$g("img_base_url") + id + ".jpg";
    },
      removeFromCart : function(pid,event){
        event.preventDefault();
				var cid=0;
        if(!this.$session.exists()){
          alert("No item in cart refresh to update")
        }else if(this.$session.has('user')){
					cid=this.$session.get('user').id;
				}
        axios
          .get(this.$g('base_url')+'/remcart/'+cid+'/'+pid)
          .then(response => {
						this.$session.set('user',response.data);
						if(this.$session.has('user')){
            this.$store.commit('updateCartCount',this.$session.get('user'));
            this.paintings=this.$session.get('user').cart.paintings;
				}
      })
			.catch(error => {
        console.log(error)
        this.errored = true
      })
      .finally(() => {
				this.loading = false;
				})
      },
      checkout : function(event){
        event.preventDefault();
        if(!this.$session.exists() || this.$session.get('user').userType == "guest"){
          alert("please signup to place order");
          this.$router.push('/signup');
        }else if(this.$session.has('user')){
			if(this.$session.get('user').cart.paintings &&  this.$session.get('user').cart.paintings.length>0){
				
				this.$router.push('/checkout');
			}	else{
				alert("Cart is empty");
			}
		}
      }
    },
    computed: {

    }
}


</script>

<style scoped>
.cart-view {
}
</style>
