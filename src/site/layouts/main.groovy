/**
 * This layout accepts the following parameters:
 *
 * @param pageTitle the page title
 * @param extraStyles , a list of CSS files to be added in the header
 * @param scripts , a list of scripts to be imported
 * @param extraFooter, a section to be added before closing body
 */

// main variables
def socializeLinks = [
        ['Learn', 'learn.html'],
        ['Download', 'download.html'],
        ['Community', 'community.html'],
        ['Ecosystem', 'ecosystem.html']]

// socialize popup items
def entries = [
        ['Mailling list', 'mailing-lists.html', 'fa-envelope'],
        ['Groovy Weekly newsletter', 'http://bit.ly/groovy-weekly-subscribe', 'fa-envelope-o'],
        ['GitHub', 'https://github.com/groovy/groovy-core', 'fa-github'],
        ['Jira', 'http://jira.codehaus.org/browse/GROOVY', 'fa-tasks'],
        ['Google+ Groovy Page', 'https://google.com/+groovy', 'fa-google-plus'],
        ['Google+ Groovy Community', 'http://bit.ly/g-community', 'fa-google-plus'],
        ['Stack overflow', 'http://stackoverflow.com/questions/tagged/groovy', 'fa-stack-overflow']
]

// main layout
yieldUnescaped '''<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->'''

html {
    head {
        meta charset: 'utf-8'
        meta 'http-equiv': 'X-UA-Compatible', content: 'IE=edge'
        title(pageTitle)
        def styles = extraStyles ?: []
        ['bootstrap.css', 'font-awesome.min.css', 'style.css', *styles].each {
            link rel: 'stylesheet', type: 'text/css', href:
                    "css/$it"
        }
    }

    body {
        // Fork me on GitHub
        a(href: 'https://github.com/groovy/groovy-core"><img style="position: absolute; top: 0; right: 0; border: 0; z-index: 100', src: 'https://camo.githubusercontent.com/365986a132ccd6a44c23a9169022c0b5c890c387/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f6769746875622f726962626f6e732f666f726b6d655f72696768745f7265645f6161303030302e706e67', alt: 'Fork me on GitHub', 'data-canonical-src': 'https://s3.amazonaws.com/github/ribbons/forkme_right_red_aa0000.png')

        div(id: 'st-container', class: "st-container st-effect-9") {
            nav(class: "st-menu st-effect-9", id: "menu-12") {
                h2(class: "icon icon-lab", 'Socialize')
                ul {
                    entries.each { text, url, style ->
                        li {
                            a(href: url, class: 'icon') { yieldUnescaped "<span class='fa $style'></span> $text" }
                        }
                    }
                }
            }

            // 'content push wrapper'

            div(class: 'st-pusher') {
                div(class: 'st-content-inner') {
                    yieldUnescaped '''<!--[if lt IE 7]>
                    <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
                <![endif]-->'''

                    // 'Content'
                    div {
                        header(id: 'header') {
                            div(class: 'row') {
                                h1(id: 'logo') { a(href: 'index.html', 'Groovy') }
                                nav(id: 'navigation') {
                                    ul {
                                        socializeLinks.each { text, url ->
                                            li { a(href: url, text) }
                                        }
                                        li {
                                            a('data-effect': 'st-effect-9', class: 'st-trigger', href: '#', 'Socialize')
                                        }
                                    }
                                }
                            }
                        }
                        // main contents goes here!
                        contents()

                        // footer
                        footer(id: 'footer') {
                            div(class: 'row') {
                                div(class: 'colset-3-footer') {
                                    div(class: 'col-1') {
                                        h1('Groovy')
                                        ul {
                                            socializeLinks.each { text, url -> li { a(href: url, text) } }
                                        }
                                    }
                                    div(class: 'col-2') {
                                        h1('About')
                                    }
                                    div(class: 'col-3') {
                                        h1('Socialize')
                                    }
                                    div(class: 'col-right') {
                                        p {
                                            yield "The Groovy programming language"; br()
                                            yield "is supported by "; a(href: 'http://gopivotal.com', 'Pivotal')
                                            yield "and the Groovy community"; br()
                                        }
                                        img(src: 'img/pivotal.png', title: 'Pivotal', alt: 'Pivotal')
                                    }
                                    div(class: 'clearfix', '&copy; 2014 the Groovy project &mdash; Groovy is Open Source, Apache 2 License')
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // bottom styles
    link href: 'http://fonts.googleapis.com/css?family=Open+Sans:400,300,200', rel: 'stylesheet', type: 'text/css'

    def scripts = extraScripts ?: []
    ['vendor/jquery-1.10.2.min.js', 'vendor/classie.js', 'vendor/sidebarEffects.js', 'plugins.js', 'main.js', *scripts].each {
        yieldUnescaped "<script src='js/$it'></script>"
    }

}