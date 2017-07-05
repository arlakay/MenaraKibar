package id.co.octolink.ilm.ersarizkidimitri.menarakibar.ui.profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import id.co.octolink.ilm.ersarizkidimitri.menarakibar.R;

public class ProfileFragment extends Fragment {
	@BindView(R.id.webview_profile)WebView webViewInfo;

	private static final String TAG = "EventFragment";
	private Unbinder unbinder;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_profile, container, false);
		ButterKnife.bind(this, view);

//		WebSettings webSettings = webViewInfo.getSettings();
//		webSettings.setJavaScriptEnabled(true);
//
//		webViewInfo.setWebViewClient(new WebViewClient());
//		webViewInfo.setWebViewClient(new WebViewClient(){
//			@Override
//			public boolean shouldOverrideUrlLoading(WebView view, String url) {
//				if (Uri.parse(url).getHost().endsWith("http://182.23.81.179/")) {
//					return false;
//				}
////				Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
////				view.getContext().startActivity(intent);
//				return super.shouldOverrideUrlLoading(view, url);
//			}
//
//			@Override
//			public void onPageStarted(WebView view, String url, Bitmap favicon) {
//				super.onPageStarted(view, url, favicon);
////				startAnim();
//			}
//
//			@Override
//			public void onPageFinished(WebView view, String url) {
//				super.onPageFinished(view, url);
////				view.loadUrl("javascript:if (typeof(document.getElementsByClassName('td-header-wrap')[0]) != 'undefined' && document.getElementsByClassName('td-header-wrap')[0] != null){document.getElementsByClassName('td-header-wrap')[0].style.display = 'none';} void 0");
////				view.loadUrl("javascript:if (typeof(document.getElementsByClassName('td-sub-footer-container')[0]) != 'undefined' && document.getElementsByClassName('td-sub-footer-container')[0] != null){document.getElementsByClassName('td-sub-footer-container')[0].style.display = 'none';} void 0");
////				view.loadUrl("javascript:if (typeof(document.getElementsByClassName('td-main-sidebar')[0]) != 'undefined' && document.getElementsByClassName('td-main-sidebar')[0] != null){document.getElementsByClassName('td-main-sidebar')[0].style.display = 'none';} void 0");
////				stopAnim();
//			}
//
//		});
//
//		webViewInfo.loadUrl("http://182.23.81.179/menara/webview/info.php");

		return view;
	}

}
