 totalEngDec22(unite: string) {
    console.log("Total eng dec23");
    this.chartService.getCategories(unite).subscribe(res=>{
      console.log("ressss :::::: "+res[0])
      this.chartService.getEngGByPeriod(unite,res[0]).subscribe(tt => {
        console.log("eeeeeooooooo :: "+tt)
        let eng : string = ""
        if(!tt.toString().includes(".")){
          eng = tt.toString()+".0"
        }else{
          eng = tt.toString()
        }
        console.log("décembre engagement ", eng)
        this.chartService.getDetails(unite, eng).subscribe(r => {
          console.log("decembre ",r)
          this.chartOptionsDec22 = {
            series: r,
            chart: {
              width: "260",
              type: "pie"
            },
            labels: ["PME", "PRF", "PAR"]
          };
        });
      })
    });
  }
