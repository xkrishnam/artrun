<template>
  <section class="popular-deals section bg-gray">
    <div class="container">
      <div class="row">
        <div class="col-sm-12 col-lg-4" v-bind:key="painting.id" v-for="painting in paintings">
          <!-- product card -->
          <artifact-details
            :key="painting.id"
            :id="painting.id"
            :title="painting.title"
            :category="painting.category"
            :price="painting.price"
            :artist="painting.artist"
          ></artifact-details>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import ArtifactDetails from "./ArtifactDetails";
export default {
  name: "ArtMainContent",
  components: { ArtifactDetails },
  props: {
    msg: String
  },
  data() {
    return {
      paintings: this.$store.state.initCache.artifacts
    };
  },
  mounted() {
    this.paintings = this.$store.state.initCache.artifacts;
  },
  methods: {
    getContentImageLink(id) {
      return this.$g("img_base_url") + id + ".jpg";
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
