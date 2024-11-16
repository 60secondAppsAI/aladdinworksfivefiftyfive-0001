import http from "../http-common"; 

class PowerUsageReportService {
  getAllPowerUsageReports(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/powerUsageReport/powerUsageReports`, searchDTO);
  }

  get(powerUsageReportId) {
    return this.getRequest(`/powerUsageReport/${powerUsageReportId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/powerUsageReport?field=${matchData}`, null);
  }

  addPowerUsageReport(data) {
    return http.post("/powerUsageReport/addPowerUsageReport", data);
  }

  update(data) {
  	return http.post("/powerUsageReport/updatePowerUsageReport", data);
  }
  
  uploadImage(data,powerUsageReportId) {
  	return http.postForm("/powerUsageReport/uploadImage/"+powerUsageReportId, data);
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

export default new PowerUsageReportService();
