#define MALLORN_COST 1200
#define MALLORN_HEALTH #MULTIPLY( MALLORN_COST 2 )
#include "includes/StandardBuildingEvaEvents.inc"
#include "..\includes\CaptureBuilding.inc"

Object ElvenMallornTree
    BuildCost = MALLORN_COST
    MaxHealth = #ADD( MALLORN_HEALTH #DIVIDE( MALLORN_COST 4 ) )
End
