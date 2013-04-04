
# AI Knowledge

There are so many problems in these fields, that with my resources and knowledge
I can scratch the surface. But, some stuff can be solved because either I am less
picky, or good/elegant solutions are available or I happen to think creatively
about these things and adjust my expectations elsewhere.

This, of course, is work in progress.

## How to crawl a quarter billion webpages in 40 hours
http://www.michaelnielsen.org/ddi/how-to-crawl-a-quarter-billion-webpages-in-40-hours/

> More precisely, I crawled 250,113,669 pages for just under 580 dollars in 39
hours and 25 minutes, using 20 Amazon EC2 machine instances.

I don't have that money available now, but like to hear more ...

> I carried out this project because (among several other reasons) I wanted to
understand what resources are required to crawl a small but non-trivial
fraction of the web.

Yes. I am interested in any results on that field, since we are trying to build
somewhat of a poor-man's AI - which needs some intelligence-like features, such
as dealing with (non)trivial questions and answers. Basically, the human facet
is for a large part rooted in philosophy, and the modern day provides us much
ways we can collect that information. I dare to postulate on the notion that
much of our 'collective' knowledge, by now, is found on the web. And if not,
there is always Google - trying even to index every book on the planet as speak.
So in many cases we may use these readily available interfaces to provide us
with mechanisms of data retrieval and information processing.

The problem is, of course, that the web is so damn big.

> What does it mean to crawl a non-trivial fraction of the web? In fact, the
notion of a “non-trivial fraction of the web” isn’t well defined. Many websites
generate pages dynamically, in response to user input – for example, Google’s
search results pages are dynamically generated in response to the user’s search
query. Because of this it doesn’t make much sense to say there are so-and-so
many billion or trillion pages on the web. This, in turn, makes it difficult to
say precisely what is meant by “a non-trivial fraction of the web”. However, as
a reasonable proxy for the size of the web we can use the number of webpages
indexed by large search engines. According to this presentation by Googler Jeff
Dean, as of November 2010 Google was indexing “tens of billions of pages”.
(Note that the number of urls is in the trillions, apparently because of
duplicated page content, and multiple urls pointing to the same content.) The
now-defunct search engine Cuil claimed to index 120 billion pages. By
comparison, a quarter billion is, obviously, very small. Still, it seemed to me
like an encouraging start.

Much like this author, I have some reservations too. Let's try and 'not be
evil' as well because this is a major concern, or at least should be, for
anyone working with AI.

> Code: Originally I intended to make the crawler code available under an open
source license at GitHub. However, as I better understood the cost that
crawlers impose on websites, I began to have reservations. My crawler is
designed to be polite and impose relatively little burden on any single
website, but could (like many crawlers) easily be modified by thoughtless or
malicious people to impose a heavy burden on sites. Because of this I’ve
decided to postpone (possibly indefinitely) releasing the code.

<!-- FIXME: better sentences -->

Back to our notion of knowledge represented as the entire web (intentionally I
discard any other information sources, due to the time it would take to invest
in indexing that). And - as mentioned, most can be found online anyway and it's
more a intellectual challenge to me than for other people, I don't believe to be
very capabable in this field: as mentioned Google is indexing books anyway.

> There’s a more general issue here, which is this: who gets to crawl the web?
Relatively few sites exclude crawlers from companies such as Google and
Microsoft. But there are a lot of crawlers out there, many of them without much
respect for the needs of individual siteowners. Quite reasonably, many
siteowners take an aggressive approach to shutting down activity from less
well-known crawlers. A possible side effect is that if this becomes too common
at some point in the future, then it may impede the development of useful new
services, which need to crawl the web. A possible long-term solution may be
services like [Common Crawl][cc], which provide access to a common corpus of
crawl data.

Great. See, I didn't even know there was a Common Crawl. We can continue there
later. For now I should mention, as with any field of study, we need a boundry
for our fields of interest. I'm not looking for the type of `emacs psych`
generic responses which, abeit of being fun for chatbots and, I must admit,
worthy to study from a semantical and linguistic perspective, not be very
useful in practice trying to answer any questions we may have on subjects.

Also since you need to train the machine, its practically and technically
impossible to know *everything* but if our notion of 'everything' shifts from
the broad spectrum of say, the universe and everything in it, to everything we
know about domain cookies, we'd get a lot more result. See below sections for
more on this.

![][http://michaelnielsen.org/ddi/wp-content/uploads/2012/08/quarter_billion_page_crawl_big_picture.png]

> The master machine (my laptop) begins by downloading Alexa’s list of the top
million domains. These were used both as a domain whitelist for the crawler,
and to generate a starting list of seed urls.

> The domain whitelist was partitioned across the 20 EC2 machine instances in the
crawler. This was done by numbering the instances  and then allocating the
domain domain to instance number hash(domain) % 20, where hash is the standard
Python hash function.

> Deployment and management of the cluster was handled using Fabric, a
well-documented and nicely designed Python library which streamlines the use of
ssh over clusters of machines. I managed the connection to Amazon EC2 using a
set of Python scripts I wrote, which wrap the boto library.

Ok going a bit too much into depth here on technology. Anyway, made up my mind:
Clojure is the main vehicle because Lisp languages just simply trumph anything
when it comes to these matters of language, congnitive processing, text and
data through it's higher-level functions, lack of side-effects, source-as-data
and so on. The list of reasons to choose Clojure over anything is huge, but few
obstacles remain.

1. I don't master the language yet
2. It is relatively new and so are its solutions (libraries, programs) although
   we partially negate this effect because of the JVM platform.
3. Some solutions on other platforms might be so good, they are equally hard to
   reproduce in a truely significant way. We need to be picky but tolerant and
   keen on those elements we find essential to our 'creature' to adopt.

Anyway, I don't need 20 machines nor can I afford them, but some user-data on
how it scales will be nice to know. It's probably more or less a linear inclination
in terms of scalability, and I don't mind having to spend 20x40 hours once we
are ready to go full scale. I must mention though, probably a portion of the data
set will be undisclosed and from iffy-sources in terms of possible violations of
laws anywhere, be it copyrights or encryption. Shame but unavoidable but you will
understand my reservations too much about that in terms of liability.

> Single instance architecture: Each instance further partitioned its domain
whitelist into 141 separate blocks of domains, and launched 141 Python threads,
with each thread responsible for crawling the domains in one block. Here’s how
it worked (details below):








Let's talk a bit more about what we like to know

Now my special professional interest is security, so a generic model or notion
of the concept 'digital security' in regards to personal computers and its
science would be cool. And besides that a cybersecuritybot just sounds cool, we
have another great advantages: much digital information is either already
inside computers such as your own, either as manual (linux, Arch) as well as
implemented as protocols, services, programs, code, compilers and what not.
Analysis of that data wouldn't cost you any bandwidth you'd only miss out on a
few essential parts:

* lessons learned

Often lessons learned are (shamefully) not part of th design process. Literate
coding never became the next best thing, and computer programs are often
written for computers and not humans so it's next to impossible to figure out
what their *intention* was when certain structures, protocols or procedures
were written. And if we know the intent, because it is so bloody obvious
something is, say optimization, even then we have to ask: what can we learn
from code? Basically you'd need a very very advanced code analysis tool that
doesn't exist of my knowledge yet. One that really extracts meaningful context
from any and all source code. But it still beats manually reading every piece
of source code and/or manual on the planet even if they were available.

This is a clear signal we have to adjust our expectations, come down from the
clouds where philosophers tend to resort, and think about some practical
solutions here. Since we barely manage basic learning of machines, I shouldn't
place too much faith in workable solutions.

Luckily, I do follow a certain amount of 'hailshot' strategies when learning to
do new stuff: spread your chances of winning just like in the casino.
Eventually, asking enough questions and being curious enough, I Google nearly
everything I don't get (even if for 5 minutes) when reading technical
documents. My curiousity would probably kill me, if I was one of my cats that is,
but I am grateful nonetheless. Although I didn't have much of a social life the
past few years in the service, I did have a lot of time to learn all about
programming and computer science (and so much more to learn) that I begin to
see perhaps why this tool, this kind of research, would actually become more
useful when taking on study subjects at a later time.

Or atleast end up with a highly interactive search and scraping tool that saves
my tons of effort when doing serious scientific research. Linux has so many
great tools that are very suitable to use, take ideas from or improve and most
of all: combine under a shared umbrella where they enhance eachothers strengths
even more.

...todo... examples on how easy it is to throw together node.js packages into
a complete new program all with the same language.

...then... apply clojure as a meta/literate/source language over data/code/web






[cc]: http://commoncrawl.org

