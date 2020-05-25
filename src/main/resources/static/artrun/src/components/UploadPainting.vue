<template lang="html">

  <section class="login py-5 border-top-1">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-5 col-md-8 align-item-center">
                <div class="border">
                    <h3 class="bg-gray p-4">Upload Painting</h3>
                    <form v-on:submit="sub" action="#" method="post">
                            <fieldset class="p-4">
                                <input v-model="title" type="text" placeholder="Title*" class="border p-3 w-100 my-2">
                                <input v-model="price" type="text" placeholder="Price*" class="border p-3 w-100 my-2">
                                <input type="file" id="file" ref="file" v-on:change="onChangeFileUpload()"/>
                                <button type="submit" class="d-block py-3 px-4 bg-primary text-white border-0 rounded font-weight-bold">Upload</button>
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
    name: 'upload-painting',
    props: [],
    mounted () {

    },
    data () {
      return {
        file: '',
        title: '',
        price: ''
      }
    },
    methods: {
            sub(event){
            event.preventDefault();
            let formData = new FormData();
            formData.append('file', this.file);
            formData.append('title',this.title);
            formData.append('price',this.price);
            formData.append('uid',this.$session.get('user').id);
  
            axios.post(this.$g('base_url')+'/uploadPainting/',
                formData,
                {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
              }
            ).then((data)=>{
              alert(data.data);
              this.$router.push("/");
            })
            .catch((error)=>{
              console.log(error);
            });
      },
  
      onChangeFileUpload(){
        this.file = this.$refs.file.files[0];
      }
    },
    computed: {

    }
}


</script>

<style scoped>
.upload-painting {
}
</style>
