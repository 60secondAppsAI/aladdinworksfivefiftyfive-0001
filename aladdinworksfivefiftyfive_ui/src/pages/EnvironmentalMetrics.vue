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
            <environmentalMetric-table
            v-if="environmentalMetrics && environmentalMetrics.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:environmentalMetrics="environmentalMetrics"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-environmental-metrics="getAllEnvironmentalMetrics"
             >

            </environmentalMetric-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import EnvironmentalMetricTable from "@/components/EnvironmentalMetricTable";
import EnvironmentalMetricService from "../services/EnvironmentalMetricService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    EnvironmentalMetricTable,
  },
  data() {
    return {
      environmentalMetrics: [],
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
    async getAllEnvironmentalMetrics(sortBy='environmentalMetricId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await EnvironmentalMetricService.getAllEnvironmentalMetrics(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.environmentalMetrics.length) {
					this.environmentalMetrics = response.data.environmentalMetrics;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching environmentalMetrics:", error);
        }
        
      } catch (error) {
        console.error("Error fetching environmentalMetric details:", error);
      }
    },
  },
  mounted() {
    this.getAllEnvironmentalMetrics();
  },
  created() {
    this.$root.$on('searchQueryForEnvironmentalMetricsChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllEnvironmentalMetrics();
    })
  }
};
</script>
<style></style>
