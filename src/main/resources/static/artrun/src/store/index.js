import Vue from "vue";
import Vuex from "vuex";
import searchPlugin from "vuex-search";
import * as getters from "./getters";
import actions from "./actions";
import mutations from "./mutations";

Vue.use(Vuex);
const initialState = {
  initCache: {
    artifacts: [],
  },
  count: 0,
  loggedin: false,
  guest: false,
  userLogged: false,
};

export default new Vuex.Store({
  getters,
  state: initialState,
  actions,
  mutations,
  plugins: [
    searchPlugin({
      resources: {
        artifacts: {
          // what fields to index
          index: ["title", "category", "artist"],
          // access the state to be watched by Vuex Search
          getter: (state) => state.initCache.artifacts,
          // how resource should be watched
          watch: { delay: 500 },
        },
        // otherResource: { index, getter, watch, searchApi },
      },
    }),
  ],
});
