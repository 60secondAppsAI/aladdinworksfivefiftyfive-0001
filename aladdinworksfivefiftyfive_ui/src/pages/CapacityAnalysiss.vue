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
            <capacityAnalysis-table
            v-if="capacityAnalysiss && capacityAnalysiss.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:capacityAnalysiss="capacityAnalysiss"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-capacity-analysiss="getAllCapacityAnalysiss"
             >

            </capacityAnalysis-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import CapacityAnalysisTable from "@/components/CapacityAnalysisTable";
import CapacityAnalysisService from "../services/CapacityAnalysisService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    CapacityAnalysisTable,
  },
  data() {
    return {
      capacityAnalysiss: [],
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
    async getAllCapacityAnalysiss(sortBy='capacityAnalysisId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await CapacityAnalysisService.getAllCapacityAnalysiss(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.capacityAnalysiss.length) {
					this.capacityAnalysiss = response.data.capacityAnalysiss;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching capacityAnalysiss:", error);
        }
        
      } catch (error) {
        console.error("Error fetching capacityAnalysis details:", error);
      }
    },
  },
  mounted() {
    this.getAllCapacityAnalysiss();
  },
  created() {
    this.$root.$on('searchQueryForCapacityAnalysissChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllCapacityAnalysiss();
    })
  }
};
</script>
<style></style>
