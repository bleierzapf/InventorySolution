<nav class="nav" role="navigation">
    <div class="container nav-elements">
        <div class="navbar">
                <a href="/dashboard">Dashboard</a>
            <div class="dropdown">
                <button class="drop-btn">Inventory Count</button>
                <div class="dropdown-content">
                    <a href="/cycleCountOverview">Cycle Count Overview</a>
                    <a href="/cycleCountRelease">Cycle Count Release</a>
                    <a href="/cycleCountManualImport">Cycle Count Manual Import</a>
                    <!-- <a href="#">Physical Inventory Release</a>
                    <a href="#">Physical Inventory Overview</a> -->
                </div> <!-- dropdown menu -->
            </div> <!-- dropdown -->
            <div class="dropdown">
            <button class="drop-btn">Import Data</button>
                <div class="dropdown-content">
                        <a href="/locationImport">Location Import</a>
                        <a href="/skuImport">Item Master Update</a>
                        <a href="/cycleCountManualImport">Cycle Count Manual Import</a>
                </div> <!-- dropdown menu -->
            </div> <!-- dropdown -->
            <a href="/tasks/viewAllTasks">Tasks</a>
            <a onclick="window.open('/mobileInterface', 'Mobile Client','width=400,height=650')">Mobile Interface</a>
            <a href="/settings">Settings</a>
        </div> <!-- navbar -->
        <div class="logo">
            LSqrd Solutions
        </div>
    </div>
</nav>
