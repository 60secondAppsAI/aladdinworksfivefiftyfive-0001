import http from "../http-common"; 

class CapacityAnalysisService {
  getAllCapacityAnalysiss(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/capacityAnalysis/capacityAnalysiss`, searchDTO);
  }

  get(capacityAnalysisId) {
    return this.getRequest(`/capacityAnalysis/${capacityAnalysisId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/capacityAnalysis?field=${matchData}`, null);
  }

  addCapacityAnalysis(data) {
    return http.post("/capacityAnalysis/addCapacityAnalysis", data);
  }

  update(data) {
  	return http.post("/capacityAnalysis/updateCapacityAnalysis", data);
  }
  
  uploadImage(data,capacityAnalysisId) {
  	return http.postForm("/capacityAnalysis/uploadImage/"+capacityAnalysisId, data);
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

export default new CapacityAnalysisService();
