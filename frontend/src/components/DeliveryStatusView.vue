<template>

    <v-data-table
        :headers="headers"
        :items="deliveryStatus"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'DeliveryStatusView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "orderId", value: "orderId" },
                { text: "storeName", value: "storeName" },
                { text: "selectManu", value: "selectManu" },
                { text: "status", value: "status" },
            ],
            deliveryStatus : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/deliveryStatuses'))

            temp.data._embedded.deliveryStatuses.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.deliveryStatus = temp.data._embedded.deliveryStatuses;
        },
        methods: {
        }
    }
</script>

