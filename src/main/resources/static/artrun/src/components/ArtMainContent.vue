<template>
  <section class="popular-deals section bg-gray" v-if="!loading">
    <search-bar @keyup="searchChange" placeholder="Search" class="searchbar" />
    <div class="container">
      <div class="row">
        <div class="col-sm-12 col-lg-4" v-bind:key="painting.id" v-for="painting in results">
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
import SearchBar from "./SearchBar";
import { mapGetters } from "vuex";
import {
  mapActions as mapSearchActions,
  mapGetters as mapSearchGetters,
  getterTypes,
  actionTypes
} from "vuex-search";
export default {
  name: "ArtMainContent",
  components: { ArtifactDetails, SearchBar },
  props: {
    msg: String
  },
  data() {
    return {
      loading: true,
      searchText: ""
    };
  },
  mounted() {
    this.loading = true;
    this.$store.dispatch("initData").finally(() => (this.loading = false));
  },
  methods: {
    getContentImageLink(id) {
      return this.$g("img_base_url") + id + ".jpg";
    },
    ...mapSearchActions("artifacts", {
      searchContacts: actionTypes.search
    }),
    searchChange(event) {
      event.preventDefault();
      this.searchText = event.target.value;
      this.searchContacts(this.searchText);
      console.log(this.resultIds);
    }
  },
  computed: {
    ...mapGetters({
      itemsMap: "currentArtifacts",
      generating: "isGenerating"
    }),
    items() {
      return Object.values(this.itemsMap);
    },
    ...mapSearchGetters("artifacts", { resultIds: getterTypes.result }),
    results() {
      if (
        this.searchText.length > 0 &&
        this.resultIds.map(id => this.itemsMap[id])[0]
      ) {
        return this.resultIds.map(id =>
          this.itemsMap.find(itm => itm.id === id)
        );
      } else {
        return Object.values(this.itemsMap);
      }
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped></style>
