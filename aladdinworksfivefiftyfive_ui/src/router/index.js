import Vue from "vue";
import VueRouter from "vue-router";
import DefaultLayout from "@/layouts/DefaultLayout.vue";
import DataCenters from  '@/pages/DataCenters.vue';
import DataCenterDetail from  '@/pages/DataCenterDetail.vue';
import MonitoringPoints from  '@/pages/MonitoringPoints.vue';
import MonitoringPointDetail from  '@/pages/MonitoringPointDetail.vue';
import TemperatureSensors from  '@/pages/TemperatureSensors.vue';
import TemperatureSensorDetail from  '@/pages/TemperatureSensorDetail.vue';
import CurrentSensors from  '@/pages/CurrentSensors.vue';
import CurrentSensorDetail from  '@/pages/CurrentSensorDetail.vue';
import Racks from  '@/pages/Racks.vue';
import RackDetail from  '@/pages/RackDetail.vue';
import PowerSupplys from  '@/pages/PowerSupplys.vue';
import PowerSupplyDetail from  '@/pages/PowerSupplyDetail.vue';
import PowerStrips from  '@/pages/PowerStrips.vue';
import PowerStripDetail from  '@/pages/PowerStripDetail.vue';
import CoolingUnits from  '@/pages/CoolingUnits.vue';
import CoolingUnitDetail from  '@/pages/CoolingUnitDetail.vue';
import Generators from  '@/pages/Generators.vue';
import GeneratorDetail from  '@/pages/GeneratorDetail.vue';
import LightSwitchs from  '@/pages/LightSwitchs.vue';
import LightSwitchDetail from  '@/pages/LightSwitchDetail.vue';
import NetworkSwitchs from  '@/pages/NetworkSwitchs.vue';
import NetworkSwitchDetail from  '@/pages/NetworkSwitchDetail.vue';
import StaticTransferSwitchs from  '@/pages/StaticTransferSwitchs.vue';
import StaticTransferSwitchDetail from  '@/pages/StaticTransferSwitchDetail.vue';
import Incidents from  '@/pages/Incidents.vue';
import IncidentDetail from  '@/pages/IncidentDetail.vue';
import IncidentReports from  '@/pages/IncidentReports.vue';
import IncidentReportDetail from  '@/pages/IncidentReportDetail.vue';
import MaintenanceRecords from  '@/pages/MaintenanceRecords.vue';
import MaintenanceRecordDetail from  '@/pages/MaintenanceRecordDetail.vue';
import CapacityAnalysiss from  '@/pages/CapacityAnalysiss.vue';
import CapacityAnalysisDetail from  '@/pages/CapacityAnalysisDetail.vue';
import PowerUsageReports from  '@/pages/PowerUsageReports.vue';
import PowerUsageReportDetail from  '@/pages/PowerUsageReportDetail.vue';
import EnvironmentalMetrics from  '@/pages/EnvironmentalMetrics.vue';
import EnvironmentalMetricDetail from  '@/pages/EnvironmentalMetricDetail.vue';
import Assets from  '@/pages/Assets.vue';
import AssetDetail from  '@/pages/AssetDetail.vue';
import Users from  '@/pages/Users.vue';
import UserDetail from  '@/pages/UserDetail.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: () => import("../views/HomeView.vue"),
			redirect: '/dataCenters',
																				  },
  {
    path: "/pricing",
    name: "PricingView",
    component: () => import("../views/PricingView.vue"),
  },
  {
    path: "/arts-gallery",
    name: "ArtsGalleryView",
    component: () => import("../views/ArtsGalleryView.vue"),
  },
  {
    path: "/checkout/:id",
    name: "CheckoutView",
    component: () => import("../views/CheckoutView.vue"),
  },
  {
    path: "/stripe-checkout",
    name: "StripeCheckoutView",
    component: () => import("../views/StripeCheckoutView.vue"),
  },
	{
		path: '/dataCenters',
		name: 'DataCenters',
		layout: DefaultLayout,
		component: DataCenters,
	},
	{
	    path: '/dataCenter/:dataCenterId', 
	    name: 'DataCenterDetail',
		layout: DefaultLayout,
	    component: DataCenterDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/monitoringPoints',
		name: 'MonitoringPoints',
		layout: DefaultLayout,
		component: MonitoringPoints,
	},
	{
	    path: '/monitoringPoint/:monitoringPointId', 
	    name: 'MonitoringPointDetail',
		layout: DefaultLayout,
	    component: MonitoringPointDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/temperatureSensors',
		name: 'TemperatureSensors',
		layout: DefaultLayout,
		component: TemperatureSensors,
	},
	{
	    path: '/temperatureSensor/:temperatureSensorId', 
	    name: 'TemperatureSensorDetail',
		layout: DefaultLayout,
	    component: TemperatureSensorDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/currentSensors',
		name: 'CurrentSensors',
		layout: DefaultLayout,
		component: CurrentSensors,
	},
	{
	    path: '/currentSensor/:currentSensorId', 
	    name: 'CurrentSensorDetail',
		layout: DefaultLayout,
	    component: CurrentSensorDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/racks',
		name: 'Racks',
		layout: DefaultLayout,
		component: Racks,
	},
	{
	    path: '/rack/:rackId', 
	    name: 'RackDetail',
		layout: DefaultLayout,
	    component: RackDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/powerSupplys',
		name: 'PowerSupplys',
		layout: DefaultLayout,
		component: PowerSupplys,
	},
	{
	    path: '/powerSupply/:powerSupplyId', 
	    name: 'PowerSupplyDetail',
		layout: DefaultLayout,
	    component: PowerSupplyDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/powerStrips',
		name: 'PowerStrips',
		layout: DefaultLayout,
		component: PowerStrips,
	},
	{
	    path: '/powerStrip/:powerStripId', 
	    name: 'PowerStripDetail',
		layout: DefaultLayout,
	    component: PowerStripDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/coolingUnits',
		name: 'CoolingUnits',
		layout: DefaultLayout,
		component: CoolingUnits,
	},
	{
	    path: '/coolingUnit/:coolingUnitId', 
	    name: 'CoolingUnitDetail',
		layout: DefaultLayout,
	    component: CoolingUnitDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/generators',
		name: 'Generators',
		layout: DefaultLayout,
		component: Generators,
	},
	{
	    path: '/generator/:generatorId', 
	    name: 'GeneratorDetail',
		layout: DefaultLayout,
	    component: GeneratorDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/lightSwitchs',
		name: 'LightSwitchs',
		layout: DefaultLayout,
		component: LightSwitchs,
	},
	{
	    path: '/lightSwitch/:lightSwitchId', 
	    name: 'LightSwitchDetail',
		layout: DefaultLayout,
	    component: LightSwitchDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/networkSwitchs',
		name: 'NetworkSwitchs',
		layout: DefaultLayout,
		component: NetworkSwitchs,
	},
	{
	    path: '/networkSwitch/:networkSwitchId', 
	    name: 'NetworkSwitchDetail',
		layout: DefaultLayout,
	    component: NetworkSwitchDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/staticTransferSwitchs',
		name: 'StaticTransferSwitchs',
		layout: DefaultLayout,
		component: StaticTransferSwitchs,
	},
	{
	    path: '/staticTransferSwitch/:staticTransferSwitchId', 
	    name: 'StaticTransferSwitchDetail',
		layout: DefaultLayout,
	    component: StaticTransferSwitchDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/incidents',
		name: 'Incidents',
		layout: DefaultLayout,
		component: Incidents,
	},
	{
	    path: '/incident/:incidentId', 
	    name: 'IncidentDetail',
		layout: DefaultLayout,
	    component: IncidentDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/incidentReports',
		name: 'IncidentReports',
		layout: DefaultLayout,
		component: IncidentReports,
	},
	{
	    path: '/incidentReport/:incidentReportId', 
	    name: 'IncidentReportDetail',
		layout: DefaultLayout,
	    component: IncidentReportDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/maintenanceRecords',
		name: 'MaintenanceRecords',
		layout: DefaultLayout,
		component: MaintenanceRecords,
	},
	{
	    path: '/maintenanceRecord/:maintenanceRecordId', 
	    name: 'MaintenanceRecordDetail',
		layout: DefaultLayout,
	    component: MaintenanceRecordDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/capacityAnalysiss',
		name: 'CapacityAnalysiss',
		layout: DefaultLayout,
		component: CapacityAnalysiss,
	},
	{
	    path: '/capacityAnalysis/:capacityAnalysisId', 
	    name: 'CapacityAnalysisDetail',
		layout: DefaultLayout,
	    component: CapacityAnalysisDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/powerUsageReports',
		name: 'PowerUsageReports',
		layout: DefaultLayout,
		component: PowerUsageReports,
	},
	{
	    path: '/powerUsageReport/:powerUsageReportId', 
	    name: 'PowerUsageReportDetail',
		layout: DefaultLayout,
	    component: PowerUsageReportDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/environmentalMetrics',
		name: 'EnvironmentalMetrics',
		layout: DefaultLayout,
		component: EnvironmentalMetrics,
	},
	{
	    path: '/environmentalMetric/:environmentalMetricId', 
	    name: 'EnvironmentalMetricDetail',
		layout: DefaultLayout,
	    component: EnvironmentalMetricDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/assets',
		name: 'Assets',
		layout: DefaultLayout,
		component: Assets,
	},
	{
	    path: '/asset/:assetId', 
	    name: 'AssetDetail',
		layout: DefaultLayout,
	    component: AssetDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/users',
		name: 'Users',
		layout: DefaultLayout,
		component: Users,
	},
	{
	    path: '/user/:userId', 
	    name: 'UserDetail',
		layout: DefaultLayout,
	    component: UserDetail,
	    props: true // Pass route params as props to the component
  	},
];

const router = new VueRouter({
  mode: "hash",
  base: process.env.BASE_URL,
  routes,
});

export default router;
