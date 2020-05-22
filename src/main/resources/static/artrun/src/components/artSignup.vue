<template lang="html">

<section class="login py-5 border-top-1">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-5 col-md-8 align-item-center">
                    <div class="border border">
                        <h3 class="bg-gray p-4">Register Now</h3>
                        <form v-on:submit="sub" action="#" method="post">
                            <fieldset class="p-4">
                                <input v-model="name" type="text" placeholder="Name*" class="border p-3 w-100 my-2">
                                <input v-model="email" type="email" placeholder="Email*" class="border p-3 w-100 my-2">
                                <input v-model="pass" type="password" placeholder="Password*" class="border p-3 w-100 my-2">
                                <input v-model="cpass" type="password" placeholder="Confirm Password*" class="border p-3 w-100 my-2">
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
    name: 'art-signup',
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
          if(this.name==""||this.email == "" || this.pass == "" || this.cpass==""){
            alert("Empty mandtory fields(*)");
          }else if(this.pass != this.cpass){
            alert("password and confirm password not matching");
          }else{
              var uid=0;
              if(this.$session.has('user')){
                  uid=this.$session.get('user').id;
              }
              axios.post('http://localhost:33445/artregister', 
              {
                            userid: uid,
                            name: this.name,
                            username: this.email,
                            password: this.pass
                        },
                        {
                   headers: {'Access-Control-Allow-Origin': '*'}
              })
                .then(response => {
                            if(response.data.status != 'SUCCESS'){
                                alert("Registration failed with ERROR : "+response.data.status);
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
      }
    },
    computed: {

    }
}


</script>

<style scoped>
.art-signup {
}
</style>
