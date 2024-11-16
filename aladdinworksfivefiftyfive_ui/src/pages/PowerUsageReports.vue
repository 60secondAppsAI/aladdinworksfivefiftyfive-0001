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
            <powerUsageReport-table
            v-if="powerUsageReports && powerUsageReports.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:powerUsageReports="powerUsageReports"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-power-usage-reports="getAllPowerUsageReports"
             >

            </powerUsageReport-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import PowerUsageReportTable from "@/components/PowerUsageReportTable";
import PowerUsageReportService from "../services/PowerUsageReportService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    PowerUsageReportTable,
  },
  data() {
    return {
      powerUsageReports: [],
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
    async getAllPowerUsageReports(sortBy='powerUsageReportId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await PowerUsageReportService.getAllPowerUsageReports(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.powerUsageReports.length) {
					this.powerUsageReports = response.data.powerUsageReports;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching powerUsageReports:", error);
        }
        
      } catch (error) {
        console.error("Error fetching powerUsageReport details:", error);
      }
    },
  },
  mounted() {
    this.getAllPowerUsageReports();
  },
  created() {
    this.$root.$on('searchQueryForPowerUsageReportsChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllPowerUsageReports();
    })
  }
};
</script>
<style></style>
