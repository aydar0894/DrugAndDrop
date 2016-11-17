<#list hotelNumbers as hotelNumber>
<div class="jumbotron">

    <md-card md-theme="{{ showDarkTheme ? 'dark-grey' : 'default' }}" md-theme-watch>

        <md-card-title>
            <md-card-title-text>
                <span class="md-headline">Hotel name: ${hotelNumber.hotel.name}</span>
                <span class="md-subhead">Hotel discription:
                    <p>Location: ${hotelNumber.hotel.hotelLocation} </p>
                    <p>room №: ${hotelNumber.number} </p>
                    <p>price(per day): ${hotelNumber.price}</span></p>
            </md-card-title-text>
            <md-card-title-media>
                <md-card>
                    <img src="/resources/images/hotelImgs/${hotelNumber.hotel.pictUrl}" class="md-card-image"
                         alt="image caption">
                </md-card>
            </md-card-title-media>
        </md-card-title>

        <md-card-actions layout="row" layout-align="end center">
            <md-button href="/booking/booking/${hotelNumber.id}">Go!</md-button>
        </md-card-actions>

    </md-card>

</div>

<hr>
</#list>
