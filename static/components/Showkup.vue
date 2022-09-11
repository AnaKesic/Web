<template>


<div>
    <v-card>
    <v-card-title>
      Svi korisnici 
      <v-spacer></v-spacer>
      <v-text-field
        v-model="search"
        append-icon="mdi-magnify"
        label="Search"
        single-line
        hide-details
      ></v-text-field>
    </v-card-title>
    <v-data-table
    :headers="headers"
    :items="items"
    hide-default-footer
    :search="search"
    
  ></v-data-table>
  </v-card>
</div>

</template>
<script>





module.exports={
name:'Showkup',
data(){
    return{
        search: '',
           headers:[
           { text: 'Korisničko ime', value: 'korisnickoIme' },
          { text: 'Ime', value: 'ime' },
          { text: 'Prezime', value: 'prezime' },
          { text: 'Uloga', value: 'uloga',filterable: false },
          { text: 'Tip korisnika', value: 'tipKupca',filterable: false },
          { text: 'Broj bodova', value: 'brojSakupljenihBodova',filterable: false }
           ],
           items:[]

    }
},
mounted() {
    this.getAll()
},

methods:{
        getAll(){

            axios.get("http://localhost:8080/rest/korisnik/getall")
         .then(r => {
            console.log(r.data)
            this.items=r.data
         })
        }
 
 }
}
</script>
<style>
</style>
