<template lang="html">

  <section class="login py-5 border-top-1">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-5 col-md-8 align-item-center">
                <div class="border">
                    <h3 class="bg-gray p-4">Login Now</h3>
                    <form v-on:submit="sub" action="#" method="post">
                            <fieldset class="p-4">
                                <input v-model="email" type="email" placeholder="Email*" class="border p-3 w-100 my-2">
                                <input v-model="pass" type="password" placeholder="Password*" class="border p-3 w-100 my-2">
                                <button type="submit" class="d-block py-3 px-4 bg-primary text-white border-0 rounded font-weight-bold">Login</button>
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
    name: 'login-page',
    props: [],
    mounted () {

    },
    data () {
      return {
          email:"",
          pass:""
      }
    },
    methods: {
      sub: function(event){
          event.preventDefault();
          if(this.email == "" || this.pass == ""){
            alert("Empty mandtory fields(*)");
          }else{
              axios.post('http://localhost:33445/artlogin/', 
              {
                            username: this.email,
                            password: this.pass
                        },
                        {
                   headers: {'Access-Control-Allow-Origin': '*'}
              })
                        .then( (response) =>{
                            if(response.data.status != 'SUCCESS'){
                                alert("Login failed invalid username/password");
                            }else{
                            this.$session.set('user',response.data.user);
                            if(this.$session.has('user')){
                            this.$store.commit('updateCartCount',this.$session.get('user'));
                            this.$store.commit('setLoginStatus', this.$session.get("user"));
                            this.$router.push("/");
                            }
                            }
                        })
                        .catch((error) => {
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
.login-page {
}
</style>
