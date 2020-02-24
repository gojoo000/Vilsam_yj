<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width">
  <title>JS Bin</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.1.0/fullcalendar.css" />
<script src="https://cdn.jsdelivr.net/momentjs/2.14.1/moment-with-locales.min.js"></script>

<!-- <script src="https://code.jquery.com/jquery-2.1.4.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.1.0/fullcalendar.js"></script>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.min.css' />
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.9.0/fullcalendar.print.css' media="print" /> -->
<script>
$(document).ready(function() {
    var lang_cd = 'ko';
    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,listMonth'
        },
        defaultDate: moment().format('YYYY-MM-DD'),
        locale: initialLocaleCode,
        editable: true,
        navLinks: true,
        eventLimit: true,
        events: function(start, end, timezone, callback) {
            $.ajax({
                url: '/test/eventAll.do',
                type : 'post',
                data : {EVENT_CODE : '11', LANG : lang_cd, startDate : start.format(), endDate : end.format() },
                dataType: 'json',
                success: function(data) {
               var events: [
    {
        title  : 'event1',
        start  : '2010-01-01'
    },
    {
        title  : 'event2',
        start  : '2010-01-05',
        end    : '2010-01-07'
    },
    {
        title  : 'event3',
        start  : '2010-01-09T12:30:00',
        allDay : false // will make the time show
    }
]
                    callback(events);
                }
            });
 
        },
        loading: function(bool) {
            $('#loading').toggle(bool);
        }
    });
});
</script>
<style>
    #loading {display:none; position:absolute; top:10px; right:10px;}
    #calendar {max-width:800px; margin:0 auto;}
</style>
</head>
<body>
    <h2>달력시작</h2>
<div id="divCalendar">
<div id="loading">loading...</div>
<div id='calendar'></div>
</div>

</body>
</html>