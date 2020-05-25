<template lang="html">

  <section class="dashboard section">
	<!-- Container Start -->
	<div class="container">
		<!-- Row Start -->
		<div class="row">
			<div class="col-md-12 offset-md-0 col-lg-12 offset-lg-0">
				<!-- Recently Favorited -->
				<div class="widget dashboard-container my-adslist">
					<h3 class="widget-header">Cart</h3>
					<table class="table table-responsive product-dashboard-table">
						<thead>
							<tr>
								<th>Image</th>
								<th>Product Title</th>
								<th>Price</th>
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
										</ul>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="3">Total</td>
								<td>{{cartTotal}}&nbsp;INR</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<!-- Row End -->
	</div>
	<!-- Container End -->
</section>

</template>

<script lang="js">

  export default  {
    name: 'order-detail-view',
    props: [],
    mounted () {
         if(this.$session.has('user')){
           var orders=this.$session.get('user').orders;
           if(orders){
             orders.forEach(element => {
               if(element.id == this.$route.params.oid){
                 this.paintings=element.cart.paintings;
                  this.cartTotal=element.cart.cartTotal;
               }
             });
           }
      }
    },
    data () {
      return {
        paintings:null,
        cartTotal:0
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
.order-detail-view {
}
</style>
