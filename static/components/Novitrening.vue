<template>
    <div class="table" style="background-color: white">
        <p style="text-align:center; font-size:40px">Create a facility content:</p>
            <form>
            <table class="table" style="background-color: gray; width: 90%; margin-left:auto; margin-right:auto">
            	<tr>
                    <td style="width: 30%; text-align:right; vertical-align:center; font-size:20px; padding-top:15px">Naziv</td>
                    <td style="width: 30%"><input class="form-control" type="text" v-model="name" name="name" style="width: 60%; border-radius:10px"/></td>
                </tr>
                <tr>
                    <td style="width: 30%; text-align:right; vertical-align:center; font-size:20px; padding-top:15px">Tip</td>
						<select style="width: 20%; height: 83%; text-align:left; vertical-align:center; font-size:20px; padding-top:15px" v-model="type" name="type" class="form-control">
						<option value="GROUP">GROUP</option>
						<option value="PERSONAL">PERSONAL</option>
						<option value="SAUNA">SAUNA</option>
						<option value="GYM">GYM</option>
				 	</select>
				 </td>
                </tr>
				<tr>
                    <td style="width: 30%; text-align:right; vertical-align:center; font-size:20px; padding-top:15px">Description</td>
                    <td style="width: 60%"><input class="form-control" type="text" v-model="description" name="description" style="width: 60%; border-radius:10px"/></td>
                </tr>
				<tr>
                    <td style="width: 30%; text-align:right; vertical-align:center; font-size:20px; padding-top:15px">Duration</td>
                    <td style="width: 60%"><input class="form-control" type="number" v-model="duration" name="duration" style="width: 60%; border-radius:10px"/></td>
                </tr>
				<tr>
                    <td style="width: 30%; text-align:right; vertical-align:center; font-size:20px; padding-top:15px">Price</td>
                    <td style="width: 60%"><input class="form-control" type="number" v-model="price" name="price" style="width: 60%; border-radius:10px"/></td>
                </tr>
                <tr>
                  <td style="width: 30%; text-align:right; vertical-align:center; font-size:20px; padding-top:15px">Image:</td>
                  <td style="width: 60%"><input type="file" style="width: 60%; border-radius:10px" class="form-control" v-model="logo" name="logo"></td>
                </tr>
				<tr v-if="type !== 'GYM' && type !== 'SAUNA'">
                    <td style="width: 30%; text-align:right; vertical-align:center; font-size:20px; padding-top:15px">Select coach</td>
						<select style="width: 60%; height: 80%; text-align:left; vertical-align:center; font-size:20px; padding-top:15px" v-model="coachId" name="coachId" class="form-control">
						<option v-for="coach in coaches" :value= coach.id>{{coach.name}}&nbsp{{coach.surname}}</option>
				 	</select>
				 </td>
                </tr>
				<tr v-if="type !== 'GYM' && type !== 'SAUNA'">
                    <td style="width: 30%; text-align:right; vertical-align:center; font-size:20px; padding-top:25px">Date</td>
                    <td><input class="form-control" v-model="date" type="datetime-local" name="date" style="width: 60%; border-radius:10px"/></td>
                </tr>
            </table>
            </form>
        </div>
   
        
    
  	
</template>
<script>
    module.exports = {
    name: 'Novitrening'
 }
</script>