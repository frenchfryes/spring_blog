/**
 * Created by frenchfryes on 6/27/17.
 */
(function($) {
    request = $.ajax({
        'url': '/posts.json'
    });
    request.done(function (ads) {
        var html = '';
        ads.forEach(function(ad) {
            html += '<div>';
            html += '<h1>' + ad.title + '</h1>';
            html += '<p>' + ad.description + '</p>';
            html += '<p>Published by ' + post.author.username + '</p>';
            html += '</div>';
        });
        $('#posts').html(html);
    });
})(jQuery);