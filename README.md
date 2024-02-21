  totalEng(unite: string) {
    console.log("Total eng");
    this.chartService.getSeries(unite).subscribe(ser => {
      console.log("serrr ", ser);
      this.serr = ser;
      this.chartOptions1 = {
        series: [
          {
            name: "Total Engagement",
            data: this.serr
          }
        ],
        chart: {
          height: 350,
          type: "bar"
        },
        plotOptions: {
          bar: {
            dataLabels: {
              position: "top" // top, center, bottom
            }
          }
        },
        dataLabels: {
          enabled: true,
          formatter: function (val: any) {
            const parts = val.toString().split('.');
            const wholePart = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ' ');
            const formattedNumber = parts.length > 1 ? wholePart + '.' + parts[1] : wholePart;
            return formattedNumber + " MD";
          },
          offsetY: -20,
          style: {
            fontSize: "12px",
            colors: ["#303C54"]
          }
        },
        xaxis: {
          categories: this.result,
          position: "bottom",
          labels: {
            offsetY: -18,
            style: {
              colors: "white"
            }
          },
          axisBorder: {
            show: false
          },
          axisTicks: {
            show: false
          },
          crosshairs: {
            fill: {
              type: "gradient",
              gradient: {
                colorFrom: "#D8E3F0",
                colorTo: "#BED1E6",
                stops: [0, 100],
                opacityFrom: 0.4,
                opacityTo: 0.5
              }
            }
          },
          tooltip: {
            enabled: false,
            offsetY: -35,
            style: {
              fontSize: "12px",
              fontFamily: "Arial, sans-serif"
            },
            formatter: (val: any) => {
              return val; // Return the formatted value
            }
          }
        },
        fill: {
          colors: ["#303C54"]
        },
        yaxis: {
          axisBorder: {
            show: false
          },
          axisTicks: {
            show: false
          },
          labels: {
            show: true,
            formatter: (val: any) => {
              return val + "";
            }
          }
        },
        title: {
          text: "Total Engagement",
          offsetY: 350,
          align: "center",
          style: {
            color: "#303C54"
          }
        }
      };
    });
  }




  <div class="col-lg-8 col-md-12">
      <div class="card" style="background-color: rgb(250, 250, 250); border-width: 0px; margin-top: 10px;">
        <div class="card-body">
          <h4 class="card-title" style="color: #303C54;">Total Engagement</h4>
          <div id="usa">
            <apx-chart [series]="chartOptions1.series" [chart]="chartOptions1.chart"
              [dataLabels]="chartOptions1.dataLabels" [plotOptions]="chartOptions1.plotOptions"
              [yaxis]="chartOptions1.yaxis" [xaxis]="chartOptions1.xaxis" [fill]="chartOptions1.fill"
              [title]="chartOptions1.title"></apx-chart>
          </div>
        </div>
      </div>
    </div>
