import http from "../http-common"; 

class LightSwitchService {
  getAllLightSwitchs(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/lightSwitch/lightSwitchs`, searchDTO);
  }

  get(lightSwitchId) {
    return this.getRequest(`/lightSwitch/${lightSwitchId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/lightSwitch?field=${matchData}`, null);
  }

  addLightSwitch(data) {
    return http.post("/lightSwitch/addLightSwitch", data);
  }

  update(data) {
  	return http.post("/lightSwitch/updateLightSwitch", data);
  }
  
  uploadImage(data,lightSwitchId) {
  	return http.postForm("/lightSwitch/uploadImage/"+lightSwitchId, data);
  }




	postRequest(url, data) {
		return http.post(url, data);
      };

	getRequest(url, params) {
        return http.get(url, {
        	params: params
        });
    };

}

export default new LightSwitchService();
