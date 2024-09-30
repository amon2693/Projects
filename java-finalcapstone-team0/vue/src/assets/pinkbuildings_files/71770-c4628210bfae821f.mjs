"use strict";(self.__LOADABLE_LOADED_CHUNKS__=self.__LOADABLE_LOADED_CHUNKS__||[]).push([[71770],{969548:(e,a,l)=>{var n;l.r(a),l.d(a,{default:()=>t});let i={argumentDefinitions:[],kind:"Fragment",metadata:null,name:"CloseupLink_pin",selections:[{alias:null,args:null,kind:"ScalarField",name:"advertiserId",storageKey:null},{alias:null,args:null,kind:"ScalarField",name:"attributionSourceId",storageKey:null},{alias:null,args:null,concreteType:"Board",kind:"LinkedField",name:"board",plural:!1,selections:[{alias:null,args:null,kind:"ScalarField",name:"url",storageKey:null}],storageKey:null},{alias:null,args:null,kind:"ScalarField",name:"campaignId",storageKey:null},{alias:null,args:null,concreteType:"PinCarouselData",kind:"LinkedField",name:"carouselData",plural:!1,selections:[{alias:null,args:null,concreteType:"PinCarouselSlot",kind:"LinkedField",name:"carouselSlots",plural:!0,selections:[{alias:"entityId",args:null,kind:"ScalarField",name:"id",storageKey:null}],storageKey:null},n={alias:null,args:null,kind:"ScalarField",name:"entityId",storageKey:null},{alias:null,args:null,kind:"ScalarField",name:"index",storageKey:null}],storageKey:null},{alias:null,args:null,kind:"ScalarField",name:"description",storageKey:null},n,{alias:null,args:null,kind:"ScalarField",name:"gridTitle",storageKey:null},{alias:null,args:null,kind:"ScalarField",name:"isDownstreamPromotion",storageKey:null},{alias:null,args:null,kind:"ScalarField",name:"isPromoted",storageKey:null},{alias:null,args:null,concreteType:"User",kind:"LinkedField",name:"pinner",plural:!1,selections:[{alias:null,args:null,kind:"ScalarField",name:"username",storageKey:null}],storageKey:null},{alias:null,args:null,kind:"ScalarField",name:"pinPromotionId",storageKey:null},{alias:null,args:null,concreteType:"User",kind:"LinkedField",name:"promoter",plural:!1,selections:[n],storageKey:null},{alias:null,args:null,kind:"ScalarField",name:"promotedIsLeadAd",storageKey:null},{alias:null,args:null,concreteType:"PromotedLeadForm",kind:"LinkedField",name:"promotedLeadForm",plural:!1,selections:[{alias:null,args:null,kind:"ScalarField",name:"leadFormId",storageKey:null}],storageKey:null},{alias:null,args:null,kind:"ScalarField",name:"storyPinDataId",storageKey:null},{alias:null,args:null,kind:"ScalarField",name:"title",storageKey:null},{alias:null,args:null,kind:"ScalarField",name:"trackingParams",storageKey:null},{args:null,kind:"FragmentSpread",name:"useGetStringifiedCommerceAuxData_pin"}],type:"Pin",abstractKey:null};i.hash="745c3a480603a026639c745fb9f1fa52";let t=i},498594:(e,a,l)=>{var n,i,t;l.r(a),l.d(a,{default:()=>s});let r={argumentDefinitions:[],kind:"Fragment",metadata:null,name:"CollageChips_pin",selections:[{alias:null,args:null,concreteType:"AggregatedPinData",kind:"LinkedField",name:"aggregatedPinData",plural:!1,selections:[{alias:null,args:null,concreteType:"PinTagChipImagesPerSpec",kind:"LinkedField",name:"pinTagsChips",plural:!0,selections:[{alias:"entityId",args:null,kind:"ScalarField",name:"id",storageKey:null},{alias:null,args:null,concreteType:"Thumbnails",kind:"LinkedField",name:"image",plural:!1,selections:[n={alias:null,args:null,kind:"ScalarField",name:"height",storageKey:null},i={alias:null,args:null,kind:"ScalarField",name:"url",storageKey:null},t={alias:null,args:null,kind:"ScalarField",name:"width",storageKey:null}],storageKey:null}],storageKey:null}],storageKey:null},{alias:null,args:null,concreteType:"CollectionPin",kind:"LinkedField",name:"collectionPin",plural:!1,selections:[{alias:null,args:null,concreteType:"CollectionPinItem",kind:"LinkedField",name:"itemData",plural:!0,selections:[{alias:null,args:null,kind:"ScalarField",name:"pinId",storageKey:null},{alias:null,args:[{kind:"Literal",name:"spec",value:"750x"}],concreteType:"Thumbnails",kind:"LinkedField",name:"images",plural:!1,selections:[i,t,n],storageKey:'images(spec:"750x")'}],storageKey:null}],storageKey:null},{args:null,kind:"FragmentSpread",name:"CollageChips_pin2"}],type:"Pin",abstractKey:null};r.hash="ccfee94118043ad859460cc7806b13e4";let s=r},387944:(e,a,l)=>{l.r(a),l.d(a,{default:()=>i});let n={argumentDefinitions:[],kind:"Fragment",metadata:null,name:"CollageChips_pin2",selections:[{args:null,kind:"FragmentSpread",name:"CloseupLink_pin"}],type:"Pin",abstractKey:null};n.hash="df1a502b4660ea1f2f0f126f142daec4";let i=n},998449:(e,a,l)=>{l.d(a,{Z:()=>t});let n=(e,a)=>0===e.lastIndexOf(a,0);var i=l(885896);let t=({url:e})=>{let a=(0,i.Z)("/");return n(e,a)?e.substr(a.length-1):e}},363074:(e,a,l)=>{l.d(a,{Z:()=>u});var n=l(667294);let i=new Map,t=null,r=e=>{e.forEach(e=>{let a=i.get(e.target);a&&a(e)})},s=e=>{t.unobserve(e),i.delete(e)},o=(e,a="-64px 0px 0px 0px",l)=>{let n={root:"undefined"==typeof document?null:document.querySelector("#mainContainer"),rootMargin:a,threshold:[0,.5,1]};t=t||new window.IntersectionObserver(r,n),i.set(e,l),t.observe(e)},d=e=>i.has(e);function u({onVisibilityChanged:e,trackFullVisible:a,rootMargin:l}){let t=(0,n.useRef)(null),r=!1,u=a=>{(r=a.intersectionRatio>0||a.isIntersecting)&&e(!0)},c=()=>{t.current instanceof HTMLElement&&d(t.current)&&r&&(e(!1),r=!1)},p=(0,n.useCallback)(e=>{t.current instanceof HTMLElement&&o(t.current,e,e=>{if(!i.has(t.current))return;let l=a?e.intersectionRatio>=1:e.intersectionRatio>=.5,n=a?0===e.intersectionRatio:!l;!r&&l?u(e):r&&n&&c()})},[t.current]);return(0,n.useEffect)(()=>(p(l),()=>{t.current instanceof HTMLElement&&(c(),s(t.current))}),[p]),t}},239821:(e,a,l)=>{l.d(a,{g:()=>p,I:()=>c});var n=l(667294),i=l(342513),t=l(705895),r=l(259866);let s={appInFocus:!0,footerPlusButtonVisible:!0,isAutoplay:!1,showTypeaheadOverlay:!1,videosAutoplaying:{currentlyPlayingOrganicVideoId:null,organicVideosAutoplaying:{},promotedVideosAutoplaying:{}},viewportSize:"lg"},o=(e=s,a)=>{if("TOGGLE_TYPEAHEAD_OVERLAY"===a.type&&e.showTypeaheadOverlay!==a.payload)return{...e,showTypeaheadOverlay:a.payload};if("SET_CURRENT_VIDEO"===a.type){let{payload:l}=a,{pinId:n,isPromoted:i,currentTime:t}=l,{videosAutoplaying:s}=e,{currentlyPlayingOrganicVideoId:o,promotedVideosAutoplaying:d,organicVideosAutoplaying:u}=s,c=(0,r.Z)(d),p=(0,r.Z)(u);return!i&&o?e:(i?c[n]={pinId:n,currentTime:t,paused:!1}:p[n]={pinId:n,currentTime:t,paused:!1},{...e,videosAutoplaying:{currentlyPlayingOrganicVideoId:i?o:n,promotedVideosAutoplaying:c,organicVideosAutoplaying:p}})}if("SET_IS_AUTOPLAY"===a.type&&e.isAutoplay!==a.payload)return{...e,isAutoplay:a.payload};if("PAUSE_CURRENT_VIDEO"===a.type){let{payload:l}=a,{pinId:n,isPromoted:i,currentTime:t}=l,{videosAutoplaying:s}=e,{promotedVideosAutoplaying:o,organicVideosAutoplaying:d}=s,u=(0,r.Z)(o),c=(0,r.Z)(d);return i?u[n]={...u[n],paused:!0,currentTime:t}:c[n]={...c[n],paused:!0,currentTime:t},{...e,videosAutoplaying:{currentlyPlayingOrganicVideoId:null,promotedVideosAutoplaying:u,organicVideosAutoplaying:c}}}if("SET_APP_FOCUS_STATE"===a.type&&e.appInFocus!==a.payload)return{...e,appInFocus:a.payload};if("SET_VIEWPORT_SIZE"===a.type&&e.viewportSize!==a.payload)return{...e,viewportSize:a.payload};if("SET_FOOTER_VISIBILITY_STATE"===a.type&&e.footerPlusButtonVisible!==a.payload)return{...e,footerPlusButtonVisible:a.payload};return e};var d=l(785893);let{Provider:u,useHook:c}=(0,i.Z)("AppUI");function p({children:e}){let[a,l]=(0,n.useReducer)(o,s),i=(0,n.useCallback)(e=>l({type:"PAUSE_CURRENT_VIDEO",payload:e}),[]),r=(0,n.useCallback)(e=>l({type:"SET_APP_FOCUS_STATE",payload:e}),[]),c=(0,n.useCallback)(e=>l({type:"SET_CURRENT_VIDEO",payload:e}),[]),p=(0,n.useCallback)(e=>l({type:"SET_FOOTER_VISIBILITY_STATE",payload:e}),[]),g=(0,n.useCallback)(e=>l({type:"SET_IS_AUTOPLAY",payload:e}),[]),y=(0,n.useCallback)(e=>l({type:"SET_VIEWPORT_SIZE",payload:e}),[]),m=(0,n.useCallback)(e=>l({type:"TOGGLE_TYPEAHEAD_OVERLAY",payload:e}),[]),_=(0,n.useMemo)(()=>({pauseAutoplay:i,setCurrentVideo:c,setFooterPlusButtonVisible:p,setIsAutoplay:g,setViewportSize:y,toggleTypeaheadOverlay:m,setAppFocusState:r,appUI:a}),[i,c,p,g,y,m,r,a]);return(0,n.useEffect)(()=>{t.Z.onSessionResume(()=>{r(!0)}).onSessionPause(()=>{r(!1)})},[r]),(0,d.jsx)(u,{value:_,children:e})}},392071:(e,a,l)=>{l.d(a,{Z:()=>g}),l(167912);var n,i,t=l(883119),r=l(207012),s=l(807023),o=l(340523),d=l(182074),u=l(785893);let c={chip:{marginRight:1,flex:"1 1 0"},chipInner:{paddingBottom:"100%"},chipContainer:{marginRight:-1}},p=void 0!==n?n:n=l(498594);function g({pinKey:e,enableCloseupLink:a}){let n=(0,r.Z)(p,e),{checkExperiment:g}=(0,o.F)(),{anyEnabled:y}=g("aid_web_collection_pin_data"),{childDataKey__DEPRECATED:m}=(0,s.Q)(void 0!==i?i:i=l(387944),n,{useLegacyAdapter:e=>({})}),{aggregatedPinData:_,collectionPin:h}=n,{pinTagsChips:k}=_||{},{itemData:S}=h||{},I=k&&k.length>=3?k.slice(0,3):[],T=S&&S.length>=3?S.slice(0,3):[];return y?(0,u.jsx)(t.xu,{dangerouslySetInlineStyle:{__style:c.chipContainer},display:"flex",children:T.map(e=>{let l=e.images||{},n=(0,u.jsx)(t.Ee,{alt:"",fit:"cover",naturalHeight:l.height??1,naturalWidth:l.width??1,role:"presentation",src:l.url??""});return(0,u.jsx)(t.xu,{dangerouslySetInlineStyle:{__style:c.chip},"data-test-id":"collageChip",children:(0,u.jsx)(t.xu,{dangerouslySetInlineStyle:{__style:c.chipInner},position:"relative",children:(0,u.jsx)(t.xu,{bottom:!0,left:!0,position:"absolute",right:!0,top:!0,children:(0,u.jsx)(t.zd,{height:"100%",wash:!0,width:"100%",children:a?(0,u.jsx)(d.Z,{collageChipId:e.pinId??"",pinKey:m,sizing:"fullSize",children:n}):n})})})},e.pinId)})}):(0,u.jsx)(t.xu,{dangerouslySetInlineStyle:{__style:c.chipContainer},display:"flex",children:I.map(e=>{let l=e.image||{},n=(0,u.jsx)(t.Ee,{alt:"",fit:"cover",naturalHeight:l.height??1,naturalWidth:l.width??1,role:"presentation",src:l.url??""});return(0,u.jsx)(t.xu,{dangerouslySetInlineStyle:{__style:c.chip},"data-test-id":"collageChip",children:(0,u.jsx)(t.xu,{dangerouslySetInlineStyle:{__style:c.chipInner},position:"relative",children:(0,u.jsx)(t.xu,{bottom:!0,left:!0,position:"absolute",right:!0,top:!0,children:(0,u.jsx)(t.zd,{height:"100%",wash:!0,width:"100%",children:a?(0,u.jsx)(d.Z,{collageChipId:e.entityId??"",pinKey:m,sizing:"fullSize",children:n}):n})})})},e.entityId)})})}},182074:(e,a,l)=>{l.d(a,{Z:()=>k}),l(167912);var n,i=l(883119),t=l(598356),r=l(214877),s=l(207012),o=l(140017),d=l(340370),u=l(340523),c=l(5859),p=l(427514),g=l(268127),y=l(149722),m=l(879977),_=l(785893);let h=void 0!==n?n:n=l(969548);function k({sizing:e="default",children:a,collageChipId:l,componentType:n,contextLogData:k,elementType:S,disableA11yLabel:I,isEggsUi:T,pinKey:f,derivedSaveButtonOptionsSavedInfo:P,productTagParentPinId:v,viewParameter:F,viewType:E}){let b=(0,o.ZP)(),{isRTL:A}=(0,c.B)(),x=(0,s.Z)(h,f),{logContextEvent:L}=(0,r.v)(),w=(0,m.E)(),{checkExperiment:K}=(0,u.F)(),{isAuth:C}=(0,y.Z)(),D=K("web_easy_gift_guide_saving",{dangerouslySkipActivation:!0}).anyEnabled,O=w.contextLogData?.story_type==="product_tagged_shopping_module_upsell",R=["polished_stacked_closeup"].includes(!A&&K(C?"closeup_auth_related_pins_above_fold_2024_dweb":"closeup_unauth_related_pins_above_fold_2024_dweb").group||""),V=C&&K("closeup_dweb_remove_magnifying_glass").anyEnabled,{carouselData:Z,entityId:j}=x,U=!!x.promotedIsLeadAd,z={},B=`/pin/${l||j}/`,H=(0,t.Xx)();if(H?.variantUrl&&(B=`/pin/${H.variantUrl}/`),Z){let{carouselSlots:e,entityId:a}=Z,l=Z.index??0;B=`/pin/${j}/`,z={carousel_slot_id:e?.[l]&&e[l].entityId,carousel_data_id:a,carousel_slot_index:l}}let Y=(0,g.Z)(x);z={...z,...Y({default:k?.commerce_data})};let N=()=>{let e={};if(U)L({event_type:8948,view_type:E||w.viewType,view_parameter:F||w.viewParameter,component:null,object_id_str:x.entityId,clientTrackingParams:x?.trackingParams,aux_data:{closeup_navigation_type:"click",lead_form_id:x.promotedLeadForm?.leadFormId,is_lead_ad:1}}),L({event_type:12,view_type:E||w.viewType,view_parameter:F||w.viewParameter,component:null,object_id_str:x.entityId,clientTrackingParams:x?.trackingParams,aux_data:{lead_form_id:x.promotedLeadForm?.leadFormId,is_lead_ad:1,...Y()}});else{let a={...k,...Y({default:k?.commerce_data})};L({event_type:101,component:n||w.componentType,element:S,object_id_str:j,clientTrackingParams:x?.trackingParams,view_type:E||w.viewType,view_parameter:F||w.viewParameter,aux_data:a}),O&&(e={storyPinProductEventData:{productPinIdStr:j,pinIdStr:v}}),L({aux_data:{closeup_navigation_type:"click",...a},component:n||w.componentType,element:S,event_data:e,event_type:8948,clientTrackingParams:x?.trackingParams,object_id_str:j,view_type:E||w.viewType,view_parameter:F||w.viewParameter})}},G={pathname:B,state:{trackingParams:x?.trackingParams,...P&&{board:P},...D&&{fromEggsBoard:T}}},M=(0,d.Z)({href:G,clientTrackingParams:x?.trackingParams,externalData:{auxData:z,pin:x&&{advertiserId:x.advertiserId,attributionSourceId:x.attributionSourceId,board:x.board&&{url:x.board.url},campaignId:x.campaignId,entityId:x.entityId,isDownstreamPromotion:x.isDownstreamPromotion,isPromoted:x.isPromoted,pinner:x.pinner&&{username:x.pinner.username},pinPromotionId:x.pinPromotionId,promoter:x.promoter&&{entityId:x.promoter.entityId},storyPinDataId:x.storyPinDataId,trackingParams:x.trackingParams}}});return(0,_.jsx)(i.Tg,{accessibilityLabel:I?void 0:(0,p.Z)(b._('{{ pinTitle }} pin page', 'pinRep.closeupLink.tapArea.accessibilityLabel', 'Accessibility label with pin title on individual links'),{pinTitle:x.gridTitle||x.title||x.description||""}),fullHeight:"fullSize"===e,fullWidth:"fullSize"===e,href:B,mouseCursor:R||V?void 0:"zoomIn",onTap:({event:e,dangerouslyDisableOnNavigation:a})=>{a(),N(),M({event:e})},rounding:2,children:a})}}}]);
//# sourceMappingURL=https://sm.pinimg.com/webapp/71770-c4628210bfae821f.mjs.map