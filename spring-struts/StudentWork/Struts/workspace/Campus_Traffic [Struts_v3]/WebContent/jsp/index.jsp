<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tiles:insert definition="standardDef" flush="true">
	<tiles:put name="title" value="Campus Traffic" type="string"/>

	<tiles:put name="head" type="string">
		<script type="text/javascript"
			      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCyghpoCtwoWIVDnTaOWba8PFyUGzEazGs">
		</script>
		<script>
		var map;
		var markers = {};
		var warnings = "<html:messages id="error" message="false"> ${error} </html:messages>";
		if(warnings != ""){
			alert(warnings);
		}
		
		function init(){
			// Initialize coordinate to MSU center
			var latLng = new google.maps.LatLng(42.7230, -84.4810);
			// Two control options don't change positions from default, they are
			// there to provide a reference for position changes (for now).
			var mapOptions = {
					center: latLng,
					zoom:17,
					mapTypeControl: false,
					panControl: false,
					streetViewControl: false,
					zoomControlOptions: {
						position: google.maps.ControlPosition.RIGHT_BOTTOM
					}
			};
			
			map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
			
			var lotInfoWindow = null;
			var marker = null;
			var info = null;
			var image = '${pageContext.request.contextPath}/images/ParkingSymbol.gif';
			
			<%-- Code to add in each of the markers --%>
			<c:forEach var='lot' items='${parkingLots}' >
			// Marker for Lot ${lot.lotName}
			<c:choose>
			<c:when test='${lot.lotOpen == "true"}'>info = '<h2>Lot ${lot.lotName}</h2><p>status: <span id="openLot">OPEN</span></p><p>capacity: ${lot.curCars}/${lot.capacity}</p>';</c:when>
			<c:otherwise>info = '<h2>Lot ${lot.lotName}</h2><p>status: <span id="closedLot">CLOSED</span></p><p>capacity: ${lot.curCars}/${lot.capacity}</p>';</c:otherwise>
			</c:choose>
			lotInfoWindow = new google.maps.InfoWindow();
			latLng = new google.maps.LatLng(${lot.xCoord}, ${lot.yCoord});
			marker = new google.maps.Marker({
				position: latLng,
				map: map,
				title: '${lot.lotName}',
				image: image
			});
			google.maps.event.addListener(marker,'click',function(content, marker){
				return function() {
					lotInfoWindow.setContent(content);
					lotInfoWindow.open(map,marker);
				};
			}(info, marker));
			
			var name = "${lot.lotName}";
			markers[name] = marker;
			</c:forEach>
			
			<c:forEach var='obs' items='${obstructions}' >
			// Marker for Lot ${obs.streetName}
			info = "<h2>${obs.streetName}</h2><p>${obs.description}</p>";
			lotInfoWindow = new google.maps.InfoWindow();
			latLng = new google.maps.LatLng(${obs.xCoord}, ${obs.yCoord});
			marker = new google.maps.Marker({
				position: latLng,
				map: map,
				title: "${obs.streetName}",
				image: image
			});
			google.maps.event.addListener(marker,'click',function(content, marker){
				return function() {
					lotInfoWindow.setContent(content);
					lotInfoWindow.open(map,marker);
				};
			}(info, marker));
			
			var name = "${lot.lotName}";
			markers[name] = marker;
			</c:forEach>

		}
		
		function scrollToMarker(selection){
			if(selection != "none"){
				var marker = markers[selection];
				map.panTo(marker.getPosition());
			}
		}
		
		google.maps.event.addDomListener(window, 'load', init);
		</script>
		<link rel="stylesheet" type="text/css" href="css/mainStyle.css" />
	</tiles:put>
	<tiles:put name="body" type="string">
		<c:choose>
			<c:when test='${not empty username and username == "admin"}'>
			</c:when>
			<c:otherwise>
				<div id="search-div">
					<h3>Jump to Lot</h3>
					<select id="lot-select" onchange="scrollToMarker(this.value)">
						<option value="none">Select a lot</option>
						<c:forEach var='lot' items='${parkingLots}' >
						<option value="${lot.lotName}">Lot ${lot.lotName}</option>
						</c:forEach>
					</select>
				</div>
			</c:otherwise>
		</c:choose>
		<div id="map-canvas"></div>
	</tiles:put>
</tiles:insert>