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
            <lightSwitch-table
            v-if="lightSwitchs && lightSwitchs.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:lightSwitchs="lightSwitchs"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-light-switchs="getAllLightSwitchs"
             >

            </lightSwitch-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import LightSwitchTable from "@/components/LightSwitchTable";
import LightSwitchService from "../services/LightSwitchService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    LightSwitchTable,
  },
  data() {
    return {
      lightSwitchs: [],
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
    async getAllLightSwitchs(sortBy='lightSwitchId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await LightSwitchService.getAllLightSwitchs(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.lightSwitchs.length) {
					this.lightSwitchs = response.data.lightSwitchs;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching lightSwitchs:", error);
        }
        
      } catch (error) {
        console.error("Error fetching lightSwitch details:", error);
      }
    },
  },
  mounted() {
    this.getAllLightSwitchs();
  },
  created() {
    this.$root.$on('searchQueryForLightSwitchsChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllLightSwitchs();
    })
  }
};
</script>
<style></style>
