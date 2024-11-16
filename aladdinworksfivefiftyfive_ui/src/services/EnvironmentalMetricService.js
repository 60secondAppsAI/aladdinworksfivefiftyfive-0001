import http from "../http-common"; 

class EnvironmentalMetricService {
  getAllEnvironmentalMetrics(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/environmentalMetric/environmentalMetrics`, searchDTO);
  }

  get(environmentalMetricId) {
    return this.getRequest(`/environmentalMetric/${environmentalMetricId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/environmentalMetric?field=${matchData}`, null);
  }

  addEnvironmentalMetric(data) {
    return http.post("/environmentalMetric/addEnvironmentalMetric", data);
  }

  update(data) {
  	return http.post("/environmentalMetric/updateEnvironmentalMetric", data);
  }
  
  uploadImage(data,environmentalMetricId) {
  	return http.postForm("/environmentalMetric/uploadImage/"+environmentalMetricId, data);
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

export default new EnvironmentalMetricService();
