import http from "../http-common"; 

class IncidentReportService {
  getAllIncidentReports(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/incidentReport/incidentReports`, searchDTO);
  }

  get(incidentReportId) {
    return this.getRequest(`/incidentReport/${incidentReportId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/incidentReport?field=${matchData}`, null);
  }

  addIncidentReport(data) {
    return http.post("/incidentReport/addIncidentReport", data);
  }

  update(data) {
  	return http.post("/incidentReport/updateIncidentReport", data);
  }
  
  uploadImage(data,incidentReportId) {
  	return http.postForm("/incidentReport/uploadImage/"+incidentReportId, data);
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

export default new IncidentReportService();
