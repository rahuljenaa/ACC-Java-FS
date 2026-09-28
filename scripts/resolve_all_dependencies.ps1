# Script to slowly and cleanly download all dependencies for all Maven projects in the repository
$ErrorActionPreference = "Continue"

$poms = Get-ChildItem -Path "$PSScriptRoot\.." -Recurse -Filter "pom.xml" | Where-Object { 
    (-not $_.FullName.Contains(".idea")) -and 
    (-not $_.FullName.Contains("target")) -and 
    (-not $_.FullName.Contains("out")) -and
    ($_.FullName -ne "$PSScriptRoot\..\pom.xml")
}

Write-Host "Found $($poms.Count) Maven projects to resolve." -ForegroundColor Cyan

$i = 0
foreach ($p in $poms) {
    $i++
    $projName = $p.Directory.Name
    Write-Host "[$i/$($poms.Count)] Downloading dependencies for $projName..." -ForegroundColor Yellow
    mvn dependency:resolve -q -f $p.FullName
    Start-Sleep -Milliseconds 200
}

Write-Host "All Maven dependencies resolved and downloaded successfully!" -ForegroundColor Green
