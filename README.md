<div class="container-fluid" style="background-color: white; margin-bottom: 10px;">
  <div class="card border-0" *ngIf="user.profile.profileType != 'AGENCE'">
    <div class="card-body">
      <div class="row">
        <div class="col-lg-11 col-md-12">
          <div class="row">
            <!-- Dropdowns -->
          </div>
        </div>
        <div class="col-lg-1 col-md-12 d-flex justify-content-end align-items-center">
          <button (click)="reset();" class="btn btn-primary" style="background-color: #303C54; color: white;">
            <svg cIcon="" name="cil-filter-x"></svg>
          </button>
        </div>
      </div>
      <hr>
    </div>
  </div>

  <div class="row" style="margin-top: 5px;">
    <div class="col-lg-8 col-md-12">
      <div class="card bg-light border-0 mt-3">
        <div class="card-body">
          <h4 class="card-title" style="color: #303C54;">Total Engagement</h4>
          <div style="width: 100%;">
            <!-- Chart -->
          </div>
        </div>
      </div>
    </div>
    <div class="col-lg-4 col-md-12">
      <div class="row">
        <div class="col-lg-12 col-md-12">
          <div class="card mt-3 bg-light border-0">
            <div class="card-body">
              <h5 class="card-title" style="color: #303C54;" [innerText]="Camembert2Name"></h5>
              <div>
                <!-- Chart -->
              </div>
            </div>
          </div>
        </div>
        <div class="col-lg-12 col-md-12">
          <div class="card bg-light border-0">
            <div class="card-body">
              <h5 class="card-title" style="color: #303C54;" [innerText]="Camembert1Name"></h5>
              <div>
                <!-- Chart -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="row" style="padding-top: 5px;">
    <!-- Similar structure for the next row -->
  </div>
</div>
