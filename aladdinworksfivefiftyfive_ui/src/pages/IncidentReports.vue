<template>
  <div class="content">
    <div class="row">
      <div class="col-12">
        <card class="card-plain">
          <!-- <template slot="header">
            <h4 class="card-title">Table on Plain Background</h4>
            <p class="category">Here is a subtitle for this table</p>
          </template>-->
          <div class="table-full-width text-left">
            <incidentReport-table
            v-if="incidentReports && incidentReports.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:incidentReports="incidentReports"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-incident-reports="getAllIncidentReports"
             >

            </incidentReport-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import IncidentReportTable from "@/components/IncidentReportTable";
import IncidentReportService from "../services/IncidentReportService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    IncidentReportTable,
  },
  data() {
    return {
      incidentReports: [],
	  totalElements: 0,
      page: 0,
      searchQuery: '',     
      table1: {
        title: "Simple Table",
        columns: [...tableColumns],
        data: [...tableData],
      },
    };
  },
  methods: {
    async getAllIncidentReports(sortBy='incidentReportId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await IncidentReportService.getAllIncidentReports(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.incidentReports.length) {
					this.incidentReports = response.data.incidentReports;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching incidentReports:", error);
        }
        
      } catch (error) {
        console.error("Error fetching incidentReport details:", error);
      }
    },
  },
  mounted() {
    this.getAllIncidentReports();
  },
  created() {
    this.$root.$on('searchQueryForIncidentReportsChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllIncidentReports();
    })
  }
};
</script>
<style></style>
