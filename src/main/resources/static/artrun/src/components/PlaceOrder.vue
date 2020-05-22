<template lang="html">

  <section class="login py-5 border-top-1">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-5 col-md-8 align-item-center">
                    <div class="border border">
                        <h3 class="bg-gray p-4">Place Order</h3>
                        <textarea v-model="address" form="usrform">Enter text here...</textarea>
                        <form v-on:submit="sub" action="#" method="post" id="placeorderform">
                            <fieldset class="p-4">
                              <button type="submit" class="d-block py-3 px-4 bg-primary text-white border-0 rounded font-weight-bold">Register Now</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>

</template>

<script lang="js">
  const axios = require('axios');
  export default  {
    name: 'place-order',
    props: [],
    mounted () {

    },
    data () {
      return {

      }
    },
    methods: {
      sub: function(event){
          event.preventDefault();
              var uid=0;
              if(this.$session.has('user')){
                  uid=this.$session.get('user').id;
              }
              axios.post('http://localhost:33445/placeorder', 
              {
                            uid: uid,
                            address: this.address
                        },
                        {
                   headers: {'Access-Control-Allow-Origin': '*'}
              })
                .then(response => {
                            if(response.data.status != 'SUCCESS'){
                                alert('Error Ocurred during request to server');
                            }else{
                            this.$session.set('user',response.data.user);
                            if(this.$session.has('user')){
                            this.$store.commit('updateCartCount',this.$session.get('user'));
                            this.$store.commit('setLoginStatus', this.$session.get("user"));
                            }
                            }
                        })
                        .catch((error) =>{
                            console.log(error);
                        });
          
      }
    },
    computed: {

    }
}


</script>

<style scoped>
.place-order {
}
</style>
