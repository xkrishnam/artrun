import axios from "axios";
import globals from "../ar-config.json";
export default {
  initData({ state }) {
    axios
      .get(globals.base_url + "/getallart")
      .then(
        (response) =>
          (state.initCache.artifacts = JSON.parse(
            JSON.stringify(response.data)
          ))
      );
  },
};
