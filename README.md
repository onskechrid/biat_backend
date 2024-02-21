<div class="container-fluid" style="background-color: white; margin-bottom: 10px; width: max-content">
  <div class="card" style="border-width: 0px;" *ngIf="user.profile.profileType != 'AGENCE'">
    <div class="card-body">
      <div class="row">
        <div class="col-lg-11 col-md-12">
          <div class="row">
            <div class="col-lg-3 col-md-12" *ngIf="user.profile.profileType != 'AGENCE'">
              <select #a (change)="handleAgenceSelection(a.value)" cSelect id="agence_select" required
                class="form-control" style="background-color: #f0f0f0; border-width: 0px;">
                <option value="default" disabled selected>Agence..</option>
                <option *ngFor="let agence of agences" [value]="agence">{{agence}}</option>
              </select>
            </div>
            <div class="col-lg-3 col-md-12" *ngIf="['PCB','RISQUE REPORTING','GROUPE', 'REGION','PBD','RISQUE CREDIT'].includes(user.profile.profileType)">
              <select #z (change)="handleZoneSelection(z.value)" cSelect id="zone_select" required
                class="form-control" style="background-color: #f0f0f0; border-width: 0px;">
                <option value="default" disabled selected>Zone..</option>
                <option *ngFor="let zone of zones" [value]="zone">{{zone}}</option>
              </select>
            </div>
            <div class="col-lg-3 col-md-12" *ngIf="['RISQUE REPORTING', 'RISQUE CREDIT', 'PCB','PBD'].includes(user.profile.profileType)">
              <select #r (change)="handleRegionSelection(r.value)" cSelect id="region_select" required
                class="form-control" style="background-color: #f0f0f0; border-width: 0px;">
                <option value="default" disabled selected>Région..</option>
                <option *ngFor="let reg of regions" [value]="reg">{{reg}}</option>
              </select>
            </div>
            <div class="col-lg-3 col-md-12" *ngIf="['RISQUE REPORTING','RISQUE CREDIT'].includes(user.profile.profileType)">
              <select #p (change)="handlePoleSelection(p.value)" cSelect id="pole_select" required
                class="form-control" style="background-color: #f0f0f0; border-width: 0px;">
                <option value="default" disabled selected>Pôle..</option>
                <option *ngFor="let pole of poles" [value]="pole">{{pole}}</option>
              </select>
            </div>
          </div>
        </div>
        <div class="col-lg-1 col-md-12" style="display: flex; justify-content: flex-end; align-items: center;">
          <button (click)="reset();" class="btn btn-primary" style="background-color: #303C54; color: white; border-color: #303C54;">
            <svg cIcon="" name="cil-filter-x"></svg>
          </button>
        </div>
      </div>
      <hr>
    </div>
  </div>

  <div class="row" style="margin-top: 5px;">
    <div class="col-lg-8 col-md-12" style="width: max-content;">
      <div class="card" style="background-color: rgb(250, 250, 250); border-width: 0px; margin-top: 10px;">
        <div class="card-body" >
          <h4 class="card-title" style="color: #303C54;">Total Engagement</h4>
          <div id="usa" style="width: 100%;">
            <apx-chart [series]="chartOptions1.series" [chart]="chartOptions1.chart"
              [dataLabels]="chartOptions1.dataLabels" [plotOptions]="chartOptions1.plotOptions"
              [yaxis]="chartOptions1.yaxis" [xaxis]="chartOptions1.xaxis" [fill]="chartOptions1.fill"
              [title]="chartOptions1.title" [legend]="chartOptions1.legend"></apx-chart>
          </div>
        </div>
      </div>
    </div>
    <div class="col-lg-4 col-md-12">
      <div class="row">
        <div class="col-lg-12 col-md-12">
          <div class="card" style="margin-top: 10px; background-color: rgb(250, 250, 250); border-width: 0px; margin-bottom: 5px;">
            <div class="card-body">
              <h5 class="card-title" style="color: #303C54;" [innerText]="Camembert2Name"></h5>
              <div id="usa">
                <apx-chart [series]="chartOptionsDec22.series" [chart]="chartOptionsDec22.chart"
                  [labels]="chartOptionsDec22.labels" [fill]="chartOptionsDec22.fill"
                  [legend]="chartOptionsDec22.legend" [tooltip]="chartOptionsDec22.tooltip"></apx-chart>
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-12 col-md-12">
          <div class="card" style="background-color: rgb(250, 250, 250); border-width: 0px;">
            <div class="card-body">
              <h5 class="card-title" style="color: #303C54;" [innerText]="Camembert1Name"></h5>
              <div id="usa">
                <apx-chart [series]="chartOptionsMars23.series" [chart]="chartOptionsMars23.chart"
                  [labels]="chartOptionsMars23.labels" [fill]="chartOptionsMars23.fill"
                  [legend]="chartOptionsMars23.legend" [tooltip]="chartOptionsMars23.tooltip"></apx-chart>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="row" style="padding-top: 5px;">
    <div class="col-lg-4 col-md-12">
      <div class="card" style="background-color: rgb(250, 250, 250); border-width: 0px;">
        <div class="card-body">
          <h4 class="card-title" style="color: #303C54;">Taux de renouvellement des PCG</h4>
          <div id="usa" style="height: auto">
            <apx-chart [series]="tauxDeRenvPCG.series" [chart]="tauxDeRenvPCG.chart"
              [dataLabels]="tauxDeRenvPCG.dataLabels" [plotOptions]="tauxDeRenvPCG.plotOptions"
              [yaxis]="tauxDeRenvPCG.yaxis" [xaxis]="tauxDeRenvPCG.xaxis" [fill]="tauxDeRenvPCG.fill"
              [title]="tauxDeRenvPCG.title" [legend]="tauxDeRenvPCG.legend"></apx-chart>
          </div>
        </div>
      </div>
    </div>
    <div class="col-lg-4 col-md-12">
      <div class="card" style="background-color: rgb(250, 250, 250); border-width: 0px;">
        <div class="card-body">
          <h4 class="card-title" style="color: #303C54;">Taux de saisie de bilan</h4>
          <div id="usa" style="height: auto">
            <apx-chart [series]="tauxDeSaisieDeBilan.series" [chart]="tauxDeSaisieDeBilan.chart"
              [dataLabels]="tauxDeSaisieDeBilan.dataLabels" [plotOptions]="tauxDeSaisieDeBilan.plotOptions"
              [yaxis]="tauxDeSaisieDeBilan.yaxis" [xaxis]="tauxDeSaisieDeBilan.xaxis" [fill]="tauxDeSaisieDeBilan.fill"
              [title]="tauxDeSaisieDeBilan.title" [legend]="tauxDeSaisieDeBilan.legend"></apx-chart>
          </div>
        </div>
      </div>
    </div>
    <div class="col-lg-4 col-md-12">
      <div class="card" style="background-color: rgb(250, 250, 250); border-width: 0px;">
        <div class="card-body">
          <h4 class="card-title" style="color: #303C54;">CDL</h4>
          <div id="sales-overview" style="min-height: auto;">
            <apx-chart [series]="tauxCDL.series" [chart]="tauxCDL.chart" [dataLabels]="tauxCDL.dataLabels"
              [plotOptions]="tauxCDL.plotOptions" [yaxis]="tauxCDL.yaxis" [xaxis]="tauxCDL.xaxis" [fill]="tauxCDL.fill"
              [title]="tauxCDL.title" [legend]="tauxCDL.legend"></apx-chart>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="row" style="margin-top: 5px;">
    <div class="col-lg-6 col-md-12">
      <div class="card" style="background-color: rgb(250, 250, 250); border-width: 0px; margin-bottom: 5px;">
        <div class="card-body">
          <h4 class="card-title" style="color: #303C54;">Taux de Génération de CDL</h4>
          <div id="usa">
            <apx-chart [series]="tauxDeGeneCDL.series" [chart]="tauxDeGeneCDL.chart"
              [dataLabels]="tauxDeGeneCDL.dataLabels" [plotOptions]="tauxDeGeneCDL.plotOptions"
              [yaxis]="tauxDeGeneCDL.yaxis" [xaxis]="tauxDeGeneCDL.xaxis" [fill]="tauxDeGeneCDL.fill"
              [title]="tauxDeGeneCDL.title" [legend]="tauxDeGeneCDL.legend"></apx-chart>
          </div>
        </div>
      </div>
    </div>
    <div class="col-lg-6 col-md-12">
      <div class="card" style="background-color: rgb(250, 250, 250); border-width: 0px;  margin-bottom: 5px;">
        <div class="card-body">
          <h4 class="card-title" style="color: #303C54;">Taux de Génération crédit Particuliers</h4>
          <div id="newsletter-campaign" style="min-height: auto;">
            <apx-chart [series]="tauxCreditPart.series" [chart]="tauxCreditPart.chart"
              [dataLabels]="tauxCreditPart.dataLabels" [plotOptions]="tauxCreditPart.plotOptions"
              [yaxis]="tauxCreditPart.yaxis" [xaxis]="tauxCreditPart.xaxis" [fill]="tauxCreditPart.fill"
              [title]="tauxCreditPart.title" [legend]="tauxCreditPart.legend"></apx-chart>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
